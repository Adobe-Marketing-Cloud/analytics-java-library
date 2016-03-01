package com.adobe.analytics.client.domain;

import java.util.ArrayList;
import java.util.List;

import com.adobe.analytics.client.AnalyticsClient;
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
