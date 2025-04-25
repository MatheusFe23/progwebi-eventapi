package br.ueg.progwebi.eventapi.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EventoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalTime dataFim;
    private boolean gratuito;
    private String local;


}
