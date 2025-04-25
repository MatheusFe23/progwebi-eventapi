package br.ueg.progwebi.eventapi.service.impl;

import br.ueg.progwebi.eventapi.model.Evento;
import br.ueg.progwebi.eventapi.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImpl implements EventService {
    @Override
    public List<Evento> listarAll() {
        return List.of();
    }

    @Override
    public Evento create(Evento evento) {
        return null;
    }

    @Override
    public Evento getById(Integer id) {
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
