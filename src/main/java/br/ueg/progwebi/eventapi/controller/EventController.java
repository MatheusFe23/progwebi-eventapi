package br.ueg.progwebi.eventapi.controller;


import br.ueg.progwebi.eventapi.controller.exceptions.ResourceNotFound;
import br.ueg.progwebi.eventapi.dto.EventDTO;
import br.ueg.progwebi.eventapi.model.Event;
import br.ueg.progwebi.eventapi.service.EventService;
import br.ueg.progwebi.eventapi.service.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public ResponseEntity<Event> createEvent(@RequestBody EventDTO event) {
        Event newEvent = eventDtoToModel(event);
        return ResponseEntity.ok(eventService.create(newEvent));
    }

    private static Event eventDtoToModel(EventDTO event) {
        Event newEvent = Event.builder()
                .nome(event.getNome())
                .descricao(event.getDescricao())
                .dataInicio(event.getDataInicio())
                .dataFim(event.getDataFim())
                .local(event.getLocal())
                .gratuito(event.isGratuito())
                .build();
        return newEvent;
    }

    @PostMapping(path = "/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDto) {
        Event eventUpdated = eventDtoToModel(eventDto);
        return eventService.update(id, eventUpdated);
    }

    @GetMapping(path = "/{id}")
    public Event getById(@PathVariable Long id) {
            return this.eventService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public Event delete(@PathVariable Long id) {
        return this.eventService.delete(id);
    }





}
