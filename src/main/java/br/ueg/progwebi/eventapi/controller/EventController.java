package br.ueg.progwebi.eventapi.controller;


import br.ueg.progwebi.eventapi.model.Event;
import br.ueg.progwebi.eventapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Objects;

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

    @PostMapping(path = "/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
        event.setId(id);
        return eventService.update(event);
    }

    @GetMapping(path = "/{id}")
    public Event getById(@PathVariable Long id) {
        Event event = this.eventService.getById(id);
        if(Objects.isNull(event)) {
            throw new HttpClientErrorException(
                    HttpStatusCode.valueOf(404),
                    "Evento não localizado");
        }
            return event;
    }







}
