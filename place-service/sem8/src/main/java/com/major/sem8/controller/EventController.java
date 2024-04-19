package com.major.sem8.controller;

import com.major.sem8.dto.EventRequest;
import com.major.sem8.entity.Event;
import com.major.sem8.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    public EventService eventService;

    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@Valid @RequestBody EventRequest eventRequestDTO) {
        Event createdEvent = eventService.addEvent(eventRequestDTO);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents(){
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id){
        return new ResponseEntity<>(eventService.getEventById(id),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<Double> getEventPrice(@PathVariable Long id){
        return new ResponseEntity<>(eventService.getPrice(id),HttpStatusCode.valueOf(200));
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<String> getEventImage(@PathVariable Long id){
        return new ResponseEntity<>(eventService.getImage(id),HttpStatusCode.valueOf(200));
    }
}
