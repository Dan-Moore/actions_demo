package com.ibm.ticketservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ibm.ticketservice.api.exceptions.TicketNotFoundException;
import com.ibm.ticketservice.api.exceptions.UserNotFoundException;
import com.ibm.ticketservice.persistence.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.ticketservice.api.dto.TicketDTO;
import com.ibm.ticketservice.persistence.entity.TicketEntity;
import com.ibm.ticketservice.persistence.repository.TicketRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class TicketService {
    private static final Logger logger = LogManager.getLogger(UserService.class);

    private final TicketRepository repo;

    @Autowired
    private ModelMapper mapper;
    private ObjectMapper jackson;

    @Autowired
    public TicketService(TicketRepository repo) {
        this.repo = repo;
        this.jackson = new ObjectMapper();
    }

    /**
     * Saves an entity to the DB
     * @param entity
     */
    public void save(TicketEntity entity) {


        repo.save(entity);


        try {
            logger.debug("Saved DB record: " + jackson.writeValueAsString(entity));
        } catch (JsonProcessingException ignored) {}
    }

    /**
     * Removes the given entity from the DB.
     * @param entity
     */
    public void delete(TicketEntity entity){
        if(entity == null || entity.getId() == null) {
            throw new TicketNotFoundException(null);
        }

        repo.delete(entity);
    }

    /**
     * Removes a record from the DB, based on ID
     * @param id
     */
    public void delete(Long id) {
        Optional<TicketEntity> entity = repo.findById(id);

        if(entity.isEmpty()) {
            throw new TicketNotFoundException(id);
        }
        entity.ifPresent(this::delete);
    }

    
	public void update(TicketDTO dto) {
		// Check if id is present.
		TicketEntity entity = convertToEntity(dto);
        if(entity == null || entity.getId() == null) {
            throw new TicketNotFoundException(null);
        }

        if(entity.getComments() == null ) {
            entity.setComments(new ArrayList<>());
        }

        save(entity);		
	}

    public void create(TicketDTO dto) {
    	TicketEntity entity = convertToEntity(dto);
        save(entity);
    }

    /**
     * Return all entries in the USERS table
     * @return
     */
    public List<TicketDTO> getAllTickets() {
        List<TicketEntity> entities = repo.findAll();

        return entities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * Returns a user for a given id
     * @param id
     * @return
     */
    public TicketDTO getTicket(Long id) {
        Optional<TicketEntity> dbRecord = repo.findById(id);
        if(dbRecord.isEmpty()) {
            throw new TicketNotFoundException(id);
        }
        return dbRecord.map(this::convertToDto).orElse(null);
    }

    /**
     * Helper method to convert Entity object into a DTO
     * @param entity
     * @return
     */
    private TicketDTO convertToDto(TicketEntity entity) {
        return mapper.map(entity, TicketDTO.class);
    }

    /**
     * Helper method to convert DTO object into an Entity
     * @param dto
     * @return
     */
    private TicketEntity convertToEntity(TicketDTO dto){
        return mapper.map(dto, TicketEntity.class);
    }
}