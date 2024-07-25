package com.ibm.ticketservice.persistence.entity;


import java.util.List;

import com.ibm.ticketservice.enums.TicketSeverity;
import com.ibm.ticketservice.enums.TicketStatus;
import com.ibm.ticketservice.enums.TicketType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class TicketEntity extends AbstractEntity {
    private String summary;
    private String component;
    private String version;
    private String milestone;

	private String description;
    
    private String type;
    
    private String severity;
    
    private String status;
    

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, 
    		orphanRemoval = true)
    private List<TicketCommentEntity> comments;

    //@OneToOne
    //private UserEntity owner;
	private Long owner_id;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMilestone() {
		return milestone;
	}

	public void setMilestone(String milestone) {
		this.milestone = milestone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<TicketCommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<TicketCommentEntity> comments) {
		this.comments = comments;
	}

	/*
	public UserEntity getOwner() {
		return owner;
	}

	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}
*/
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}
}