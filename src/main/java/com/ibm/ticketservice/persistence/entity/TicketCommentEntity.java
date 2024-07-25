package com.ibm.ticketservice.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_comments")
public class TicketCommentEntity extends AbstractEntity {
    private String comment;
    
    @ManyToOne
    private TicketEntity ticket;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public TicketEntity getTicket() {
		return ticket;
	}

	public void setTicket(TicketEntity ticket) {
		this.ticket = ticket;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
}