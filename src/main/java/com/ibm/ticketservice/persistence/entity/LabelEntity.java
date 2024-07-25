package com.ibm.ticketservice.persistence.entity;

import com.ibm.ticketservice.enums.LabelType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "label")
public class LabelEntity extends AbstractEntity {
    private String type;
	private String title;
    
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}