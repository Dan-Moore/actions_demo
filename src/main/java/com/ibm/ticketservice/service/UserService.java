package com.ibm.ticketservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ibm.ticketservice.api.exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.ticketservice.api.dto.UserDTO;
import com.ibm.ticketservice.persistence.entity.UserEntity;
import com.ibm.ticketservice.persistence.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Service
public class UserService {

    private static final Logger logger = LogManager.getLogger(UserService.class);

    private final UserRepository repo;

    @Autowired
    private ModelMapper mapper;
    private ObjectMapper jackson;

    @Autowired
    public UserService(UserRepository repo) {
        this.repo = repo;
        this.jackson = new ObjectMapper();
    }

    /**
     * Saves an entity to the DB
     * @param entity
     */
    public void save(UserEntity entity) {
        repo.save(entity);

        try {
            logger.debug("Saved DB record: " + jackson.writeValueAsString(entity));
        } catch (JsonProcessingException ignored) {}
    }

    /**
     * Removes the given entity from the DB.
     * @param entity
     */
    public void delete(UserEntity entity){
        repo.delete(entity);

        try {
            logger.debug("Deleted DB record: " + jackson.writeValueAsString(entity));
        } catch (JsonProcessingException ignored) {}
    }

    /**
     * Removes a record from the DB, based on ID
     * @param id
     */
    public void delete(Long id) {
        Optional<UserEntity> entity = repo.findById(id);
        if(entity.isEmpty()) {
            throw new UserNotFoundException(null);
        }
        entity.ifPresent(this::delete);
    }

    
	public void update(UserDTO dto) {
		UserEntity entity = convertToEntity(dto);
        if(entity.getId() == null) {
            throw new UserNotFoundException(null);
        }
        save(entity);		
	}

    public void create(UserDTO dto) {
        UserEntity entity = convertToEntity(dto);
        save(entity);
    }

    /**
     * Return all entries in the USERS table
     * @return
     */
    public List<UserDTO> getAllUsers() {
        List<UserEntity> entities = repo.findAll();

        return entities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * Returns a user for a given id
     * @param id
     * @return
     */
    public UserDTO getUser(Long id) {
        Optional<UserEntity> dbRecord = repo.findById(id);
        if(dbRecord.isEmpty()) {
            throw new UserNotFoundException(id);
        }
        return dbRecord.map(this::convertToDto).orElse(null);
    }

    /**
     * Helper method to convert Entity object into a DTO
     * @param entity
     * @return
     */
    private UserDTO convertToDto(UserEntity entity) {

        return mapper.map(entity, UserDTO.class);
    }

    /**
     * Helper method to convert DTO object into an Entity
     * @param dto
     * @return
     */
    private UserEntity convertToEntity(UserDTO dto){
        return mapper.map(dto, UserEntity.class);
    }
}