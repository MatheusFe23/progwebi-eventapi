package br.ueg.progwebi.eventapi.controller;


import br.ueg.progwebi.eventapi.model.Event;
import br.ueg.progwebi.eventapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path  = "/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> listAllEvents() {
        return eventService.listAll();
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.create(event);
    }








}
