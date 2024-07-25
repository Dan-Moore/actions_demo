package com.ibm.ticketservice.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TicketSeverity {
	CRITICAL, MAJOR, NORMAL, MINOR
}
