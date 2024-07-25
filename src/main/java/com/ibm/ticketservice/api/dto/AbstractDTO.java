package com.ibm.ticketservice.api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public abstract class AbstractDTO {
    private Long id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
    private Date created;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
    private Date updated;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
