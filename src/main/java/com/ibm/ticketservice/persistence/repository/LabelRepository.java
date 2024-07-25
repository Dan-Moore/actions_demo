package com.ibm.ticketservice.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.ticketservice.persistence.entity.LabelEntity;

@Repository
public interface LabelRepository extends JpaRepository<LabelEntity, Long> {

}