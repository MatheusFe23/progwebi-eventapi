package br.ueg.progwebi.eventapi.service;

import br.ueg.progwebi.eventapi.model.Event;

import java.util.List;

public interface EventService {
    List<Event> listAll();
    Event create(Event event);
    Event getById(int id);
    void delete(int id);
    Event update(Event event);
}
