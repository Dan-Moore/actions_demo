package com.ibm.ticketservice.api.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.ibm.ticketservice.enums.LabelType;

public class LabelDTO extends AbstractDTO {
    private String title;

	private String type;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}