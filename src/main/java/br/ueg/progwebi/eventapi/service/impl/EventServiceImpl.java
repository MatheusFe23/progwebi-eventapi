package br.ueg.progwebi.eventapi.service.impl;

import br.ueg.progwebi.eventapi.model.Evento;
import br.ueg.progwebi.eventapi.repository.EventRepository;
import br.ueg.progwebi.eventapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Evento> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public Evento create(Evento evento) {
        return null;
    }

    @Override
    public Evento getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Evento update(Evento evento) {
        return null;
    }
}
