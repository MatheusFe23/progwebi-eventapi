package br.ueg.progwebi.eventapi.dtos;

import br.ueg.progwebi.eventapi.model.Evento;
import lombok.Data;

import java.util.List;

@Data
public class EventoDTO {
    private Long id;
    private String nome;
    private String descricao;


}
