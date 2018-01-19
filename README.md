# Analytics Java library

A Java client library for the [Analytics APIs](https://marketing.adobe.com/developer/documentation).

## Integration

Add following dependency to your `pom.xml`:

    <dependency>
        <groupId>com.adobe.granite.analytics</groupId>
        <artifactId>java-client</artifactId>
        <version>1.2</version>
    </dependency>
    
Also, you may need to configure the Maven setup to access [Adobe Public Maven Repository](https://repo.adobe.com/).

## Usage

### Creating the AnalyticsClient instance

`AnalyticsClientBuilder` class allows to create the `AnalyticsClient` instances:

    AnalyticsClient client = new AnalyticsClientBuilder()
        .setEndpoint("api2.omniture.com")
        .authenticateWithSecret("my-username", "my-password")
        .build();

### Reading the report suite configuration

`ReportSuiteMethods` exposes API methods related to the report suite
configuration. For instance, you may get the list of the report suites:

    ReportSuiteMethods suiteMethods = new ReportSuiteMethods(client); //client is created as above
    CompanyReportSuites reportSuites = suiteMethods.getReportSuites();
    for (CompanyReportSuite suite : reportSuites.getReportSuites()) {
        System.out.println(suite.toString());
    }

You may also fetch the evars and props list for a specific suite or
suites:

    ReportSuiteEvars evars = suiteMethods.getEvars("a_valid_rsid").get(0); //you may pass more than one rsid
    for (Evar evar : evars.getEvars()) {
        System.out.println(evar.toString());
    }

    ReportSuiteProps props = suiteMethods.getProps("a_valid_rsid").get(0);
    for (Prop prop : props.getProps()) {
        System.out.println(prop.toString());
    }

### Generating a report

In order to generate a report, you need to prepare the report
description:

    ReportDescription desc = new ReportDescription();
    desc.setReportSuiteID("a_valid_rsid");
    desc.setDateFrom("2015-01-01"); // YYYY-MM-DD
    desc.setDateTo("2015-01-30");
    desc.setDateGranularity(ReportDescriptionDateGranularity.WEEK);
    desc.setMetricIds("event1", "event2");
    desc.setElementIds("eVar1", "eVar7");

Pass the description to the API queue method, which will start the
process of preparing the report:

    ReportMethods reportMethods = new ReportMethods(client);
    int reportId = reportMethods.queue(desc);

The received integer is a report id, which can be used to receive the
actual report using the `get()` method. Preparing report takes some
time, and the `get()` method will throw an exception with appropriate
message if the report is not ready yet. Following code runs the `get()`
method in a loop, waiting until the report is ready:

    ReportResponse response = null;
    while (response == null) {
        try {
            response = reportMethods.get(reportId);
        } catch (ApiException e) {
            if ("report_not_ready".equals(e.getError())) {
                System.err.println("Report not ready yet.");
                Thread.sleep(3000);
                continue;
            }
            throw e;
        }
    }

More information about preparing a report can be found in the Adobe
analytics [documentation](https://marketing.adobe.com/developer/documentation/analytics-reporting-1-4/get-started).

### Iterating bookmarked reports
Sometimes it's useful to get a ReportDescription directly from an existing bookmarked report on the Analytics website.  
How to iterate bookmarks:

    ReportSuiteMethods suiteMethods = new ReportSuiteMethods(client); //client is created as above
    List<BookmarkFolder> folders = suiteMethods.getBookmarksFolders();
    for (BookmarkFolder folder : folders) {
        System.out.println("Bookmarked reports in folder " + folder.getName());
        for (Bookmark bookmark : folder.getBookmarks()) {
            System.out.println("  " + bookmark.getName());
            ReportDescription desc = bookmark.getReportDescription();
            // now it's possible to pass the desc object to the API queue method  
            // in order to get the actual report, as shown above.
        }
    }
  
### Getting a bookmarked report by name
It's also possible to get a bookmarked report directly by name:

    ReportSuiteMethods suiteMethods = new ReportSuiteMethods(client); //client is created as above
    ReportDescription desc = suiteMethods.getReportDescriptionByBookmarkName("your-bookmark-name");

### Adding an user

`PermissionsMethods` class allows to create a new user:

    AddLogin newUser = new AddLogin();
    newUser.setEmail("test@example.com");
    newUser.setLogin("test");
    newUser.setPassword("test123");
    newUser.setFirstName("John");
    newUser.setLastName("Doe");

    PermissionsMethods permMethods = new PermissionsMethods(client);
    if (permMethods.addLogin(newUser)) {
        System.out.println("Success!");
    }

### Custom request

It's also possible to send a custom JSON request and receive an JSON
response, if the desired method is not already covered by the above Java
API. GSON library provides a convenient way to create a request and
parse the result. For instance, we may use the raw JSONs to get the list
of the report suites:

    JsonObject request = new JsonObject();
    JsonArray typeList = new JsonArray();
    typeList.add(new JsonPrimitive("standard"));
    request.add("types", typeList);

    JsonObject response = client.callMethod("Company.GetReportSuites", request, JsonObject.class);
    JsonArray suites = response.get("reportSuites").getAsJsonArray();
    for (JsonElement suite : suites) {
        System.out.println(suite.getAsJsonObject().get("siteTitle").getAsString());
    }

The `JsonUtil` utility class contains two useful methods for creating
objects and arrays: `o("k1", "v1", "k2", "v2", ...)` and `a("v1", "v2", "v3", ...)`. Example:

    Object request = o("types", a("standard"));
    JsonObject response = client.callMethod("Company.GetReportSuites", request, JsonObject.class);

### JWT/OAuth authorization

The library supports
[service account authorization](https://marketing.adobe.com/developer/documentation/authentication-1/auth-service-account-1).
In order to use it, you'll need:

* a private key file,
* client id,
* username.

Creating an `AnalyticsClient` authorized with OAuth is simple:

    AnalyticsClient client = new AnalyticsClientBuilder()
        .setEndpoint("api2.omniture.com")
        .authenticateWithJWTOAuth(privateKeyPath, "my-client-id", "my-username")
        .build();

OAuth authentication using the credentials is possible as well:

    AnalyticsClient client = new AnalyticsClientBuilder()
        .setEndpoint("api2.omniture.com")
        .authenticateWithClientCredentialsOAuth("my-client-id", "my-secret")
        .build();
