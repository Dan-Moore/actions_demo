package com.ibm.ticketservice.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ibm.ticketservice.api.dto.UserDTO;
import com.ibm.ticketservice.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService service;

	@Autowired
	public UserController(UserService userService) {
		this.service = userService;
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> fetchUsers() {
		List<UserDTO> users = service.getAllUsers();

		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> fetchUser(@PathVariable long id) {
		UserDTO user = service.getUser(id);

		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/create")
	@CrossOrigin(origins= "http://localhost:3000")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
		service.create(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	@CrossOrigin(origins= "http://localhost:3000")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO dto) {
		service.update(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins= "http://localhost:3000")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}