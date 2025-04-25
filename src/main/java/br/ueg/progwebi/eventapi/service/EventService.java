package br.ueg.progwebi.eventapi.service;

import br.ueg.progwebi.eventapi.model.Evento;

import java.util.List;

public interface EventService {
    List<Evento> listAll();
    Evento create(Evento evento);
    Evento getById(int id);
    void delete(int id);
    Evento update(Evento evento);
}
