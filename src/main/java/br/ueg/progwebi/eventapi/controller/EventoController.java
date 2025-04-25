package br.ueg.progwebi.eventapi.controller;


import br.ueg.progwebi.eventapi.model.Evento;
import br.ueg.progwebi.eventapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path  = "/event")
public class EventoController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Evento> listAllEventos() {
        return eventService.listAll();
    }








}
