package dev.djigit99.chesswebsitebackend.controllers;

import dev.djigit99.chesswebsitebackend.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public ResponseEntity<?> getEvents() {
        return ResponseEntity.ok(eventRepository.findAll());
    }
}
