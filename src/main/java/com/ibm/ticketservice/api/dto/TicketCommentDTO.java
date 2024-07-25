package com.ibm.ticketservice.api.dto;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

public class TicketCommentDTO {
    private Long id;
    private String comment;
    @DateTimeFormat(pattern ="DD-MM-YYYY")
    private Timestamp created;
    @DateTimeFormat(pattern ="DD-MM-YYYY")
    private Timestamp updated;
    private UserDTO user;
    
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
}