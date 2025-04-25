package br.ueg.progwebi.eventapi.service;

import br.ueg.progwebi.eventapi.model.Evento;

import java.util.List;

public interface EventService {
    List<Evento> listarAll();
    Evento create(Evento evento);
    Evento getById(Integer id);
    void delete(int id);
    Evento update(Evento evento);
}
