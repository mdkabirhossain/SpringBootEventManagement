package com.curd.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curd.eventeposotry.EventCurdResository;
import com.curd.exception.EventNotFoundException;
import com.curd.model.EventModel;

@RestController
public class EvenController {

	@Autowired
	EventCurdResository eventurdresository;

	@PostMapping("/events")
	public void saveEvent(@RequestBody EventModel event) {
		eventurdresository.save(event);
	}

	@GetMapping("/events")
	public List<EventModel> getEvents() {
		return eventurdresository.findAll();
	}

	@PutMapping("/events")
	public EventModel updateEvent(@RequestBody EventModel eventmodel) {
		return eventurdresository.save(eventmodel);
	}

	@DeleteMapping("/events/{id}")
	public void deleteEvent(@PathVariable Long id) {
		eventurdresository.deleteById(id);
	}

	@GetMapping("/events/{id}")
	public EventModel getEventsById(@PathVariable Long id) {
	
		Optional<EventModel> event = eventurdresository.findById(id);
		
		if (!event.isPresent()) {
			throw new EventNotFoundException("Id is not found");
		}
		return event.get();

	}
}
