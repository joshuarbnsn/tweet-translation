package com.mulesoft.demo.translation.dto.input;

import org.codehaus.jackson.annotate.JsonProperty;

public class Message {

	@JsonProperty("Text")
	protected String text;
	
	@JsonProperty("Tags")
	protected String tags;
	
	@JsonProperty("Users")
	protected String users;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}
	
}
