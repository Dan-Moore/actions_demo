package com.ibm.ticketservice.api.exceptions;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(Long id) {
        super("Ticket not found with ID: " + (id != null ? id : "null"));
    }
}