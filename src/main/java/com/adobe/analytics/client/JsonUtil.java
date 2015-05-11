package com.adobe.analytics.client;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

	public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	private JsonUtil() {
	}

	public static Map<Object, Object> m(Object... values) {
		final Map<Object, Object> map = new LinkedHashMap<>();
		for (int i = 0; i < values.length - 1; i += 2) {
			map.put(values[i], values[i + 1]);
		}
		return map;
	}

	public static List<Object> l(Object... values) {
		return Arrays.asList(values);
	}
}