package com.ibm.ticketservice.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TicketStatus {
	NEW, CLOSED, ASSIGNED
}
