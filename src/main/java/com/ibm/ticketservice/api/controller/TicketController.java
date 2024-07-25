package com.ibm.ticketservice.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ticketservice.api.dto.TicketDTO;
import com.ibm.ticketservice.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
	
	private final TicketService service;

	@Autowired
	public TicketController(TicketService ticketService) {
		this.service = ticketService;
	}

	@GetMapping
	public ResponseEntity<List<TicketDTO>> fetchTickets() {
		List<TicketDTO> tickets = service.getAllTickets();

		if (tickets == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TicketDTO> fetchTicket(@PathVariable long id) {
		TicketDTO user = service.getTicket(id);

		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/create")
	@CrossOrigin(origins= "http://localhost:3000")
	public ResponseEntity<TicketDTO> createUser(@RequestBody TicketDTO dto) {
		service.create(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	@CrossOrigin(origins= "http://localhost:3000")
	public ResponseEntity<TicketDTO> updateUser(@RequestBody TicketDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<TicketDTO> deleteUser(@PathVariable long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
