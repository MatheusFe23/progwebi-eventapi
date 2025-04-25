package br.ueg.progwebi.eventapi.controller;

import br.ueg.progwebi.eventapi.model.Evento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path  = "/event")
public class EventoController {
    public String listAll(){
        Evento evento = new Evento();
        return evento.toString();
    }

}
