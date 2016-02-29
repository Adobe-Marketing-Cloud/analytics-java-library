package com.adobe.analytics.client.domain;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BookmarkFolder {
	
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

}
