package com.ibm.ticketservice.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity {
    private String first_name;
    private String last_name;
    private String email;
    private String slack;

	/*
    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL, 
    		orphanRemoval = true)
    private TicketEntity ticket;
   */
	
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
	/*
	public TicketEntity getTicket() {
		return ticket;
	}
	public void setTicket(TicketEntity ticket) {
		this.ticket = ticket;
	}
	*/
}