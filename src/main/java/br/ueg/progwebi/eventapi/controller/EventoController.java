package br.ueg.progwebi.eventapi.controller;

import br.ueg.progwebi.eventapi.model.Evento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path  = "/event")
public class EventoController {
    @GetMapping
    public List<Evento> eventos() {
        return null;
    }

}
