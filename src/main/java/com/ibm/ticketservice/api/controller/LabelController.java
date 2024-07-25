package com.ibm.ticketservice.api.controller;

import com.ibm.ticketservice.api.dto.LabelDTO;
import com.ibm.ticketservice.api.dto.UserDTO;
import com.ibm.ticketservice.enums.LabelType;
import com.ibm.ticketservice.service.LabelService;
import com.ibm.ticketservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labels")
public class LabelController {
    private final LabelService service;

    @Autowired
    public LabelController(LabelService userService) {
        this.service = userService;
    }

    @GetMapping
    public ResponseEntity<List<LabelDTO>> get(@RequestParam(required = false) String type) {
        if(type == null){
            List<LabelDTO> labels = service.getAll();
            return new ResponseEntity<>(labels, HttpStatus.OK);
        }  else {
            List<LabelDTO> labels = service.getByType(type);
            return new ResponseEntity<>(labels, HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    @CrossOrigin(origins= "http://localhost:3000")
    public ResponseEntity<LabelDTO> createLabel(@RequestBody LabelDTO dto) {
        service.create(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins= "http://localhost:3000")
    public ResponseEntity<LabelDTO> deleteLabel(@PathVariable long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
