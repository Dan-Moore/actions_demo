package com.ibm.ticketservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.ticketservice.api.dto.LabelDTO;
import com.ibm.ticketservice.api.dto.UserDTO;
import com.ibm.ticketservice.api.exceptions.UserNotFoundException;
import com.ibm.ticketservice.enums.LabelType;
import com.ibm.ticketservice.persistence.entity.LabelEntity;
import com.ibm.ticketservice.persistence.entity.UserEntity;
import com.ibm.ticketservice.persistence.repository.LabelRepository;
import com.ibm.ticketservice.persistence.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LabelService {
    private static final Logger logger = LogManager.getLogger(UserService.class);

    private final LabelRepository repo;

    @Autowired
    private ModelMapper mapper;
    private ObjectMapper jackson;

    @Autowired
    public LabelService(LabelRepository repo) {
        this.repo = repo;
        this.jackson = new ObjectMapper();
    }

    /**
     * Saves an entity to the DB
     * @param entity
     */
    public void save(LabelEntity entity) {
        repo.save(entity);

        try {
            logger.debug("Saved DB record: " + jackson.writeValueAsString(entity));
        } catch (JsonProcessingException ignored) {}
    }

    /**
     * Removes the given entity from the DB.
     * @param entity
     */
    public void delete(LabelEntity entity){
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
        Optional<LabelEntity> entity = repo.findById(id);
        if(entity.isEmpty()) {
            throw new UserNotFoundException(null);
        }
        entity.ifPresent(this::delete);
    }


    public void update(LabelDTO dto) {
        LabelEntity entity = convertToEntity(dto);
        if(entity.getId() == null) {
            throw new UserNotFoundException(null);
        }
        save(entity);
    }

    public void create(LabelDTO dto) {
        LabelEntity entity = convertToEntity(dto);
        save(entity);
    }

    /**
     * Return all entries in the USERS table
     * @return
     */
    public List<LabelDTO> getAll() {
        List<LabelEntity> entities = repo.findAll();

        return entities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * Returns a user for a given id
     * @param type
     * @return
     */
    public List<LabelDTO> getByType(String type) {
        List<LabelEntity> entities = repo.findAll();

        return entities.stream().filter(entity -> type.equalsIgnoreCase(entity.getType()))
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * Helper method to convert Entity object into a DTO
     * @param entity
     * @return
     */
    private LabelDTO convertToDto(LabelEntity entity) {
        return mapper.map(entity, LabelDTO.class);
    }

    /**
     * Helper method to convert DTO object into an Entity
     * @param dto
     * @return
     */
    private LabelEntity convertToEntity(LabelDTO dto){
        return mapper.map(dto, LabelEntity.class);
    }
}
