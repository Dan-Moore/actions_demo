package com.ibm.ticketservice.api.dto;

import java.util.List;

import com.ibm.ticketservice.enums.TicketSeverity;
import com.ibm.ticketservice.enums.TicketStatus;
import com.ibm.ticketservice.enums.TicketType;

public class TicketDTO extends AbstractDTO{
    private String summary;
    private String component;
    private String version;
    private String milestone;
    private String type;
    private String severity;
    private String status;
	private String description;
    private List<TicketCommentDTO> comments;
    private UserDTO owner;

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
	public List<TicketCommentDTO> getComments() {
		return comments;
	}
	public void setComments(List<TicketCommentDTO> comments) {
		this.comments = comments;
	}
	public UserDTO getOwner() {
		return owner;
	}
	public void setOwner(UserDTO owner) {
		this.owner = owner;
	}

	public String getDescription() {
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