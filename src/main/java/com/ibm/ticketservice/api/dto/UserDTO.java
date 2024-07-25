package com.ibm.ticketservice.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    private Long id;
    @JsonProperty("firstName")
    private String first_name;
    @JsonProperty("lastName")
    private String last_name;
    private String email;
    private String slack;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSlack() {
		return slack;
	}
	public void setSlack(String slack) {
		this.slack = slack;
	}
}