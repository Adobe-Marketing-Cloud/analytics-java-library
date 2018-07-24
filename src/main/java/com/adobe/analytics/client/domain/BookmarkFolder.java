/*
Copyright 2018 Adobe. All rights reserved.
This file is licensed to you under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License. You may obtain a copy
of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under
the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
OF ANY KIND, either express or implied. See the License for the specific language
governing permissions and limitations under the License.
*/

package com.adobe.analytics.client.domain;

import java.util.ArrayList;
import java.util.List;

import com.adobe.granite.analytics.client.AnalyticsClient;
import com.google.gson.annotations.SerializedName;

public class BookmarkFolder {

	private AnalyticsClient client;
	
	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public String getOwner() {
		return owner;
	}

	public List<Bookmark> getBookmarks() {
		// slightly inefficient, but it ensures the client obj availability
		for (Bookmark bookmark : bookmarks) {
			bookmark.setClient(this.client);
		}
		
		return bookmarks;
	}

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private Long id;
	
	@SerializedName("owner")
	private String owner;
	
	@SerializedName("bookmarks")
	private List<Bookmark> bookmarks;

	public void setBookmarks(List<Bookmark> bookmarks) {
		System.out.println("setting bookmark list");
		this.bookmarks = bookmarks;
	}

	public BookmarkFolder() {
		this.bookmarks = new ArrayList<Bookmark>();
	}

	public void setClient(AnalyticsClient client) {
		this.client = client;
	}
}
