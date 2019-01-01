package com.curd.eventeposotry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curd.model.EventModel;

@Repository
public interface EventCurdResository extends JpaRepository<EventModel, Long> {
	
}
