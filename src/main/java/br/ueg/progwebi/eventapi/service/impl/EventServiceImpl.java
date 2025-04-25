package br.ueg.progwebi.eventapi.service.impl;

import br.ueg.progwebi.eventapi.model.Event;
import br.ueg.progwebi.eventapi.repository.EventRepository;
import br.ueg.progwebi.eventapi.service.EventService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event create(Event event) {
        if(Strings.isEmpty(event.getNome())) {
            throw new RuntimeException("Nome não pode ser nulo");
        }
        Optional validarId = eventRepository.findById(event.getId());
        if(validarId.isPresent()) {
            throw new RuntimeException("Id já existe.");
        }
        return eventRepository.save(event);
    }

    @Override
    public Event update(Event event) {
        if(Strings.isEmpty(event.getNome()) || Objects.isNull(event.getId())) {
            throw new RuntimeException("Dados incompletos");
        }
        return eventRepository.save(event);
    }

    @Override
    public Event getById(Long id) {
        Optional<Event> event = this.eventRepository.findById(id);
        if (event.isPresent()) {
            return event.get();
        }

        return null;
    }

    @Override
    public void delete(Long id) {

    }


}
