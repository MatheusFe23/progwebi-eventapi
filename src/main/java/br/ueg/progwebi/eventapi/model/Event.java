package br.ueg.progwebi.eventapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

//import static jakarta.persistence.GenerationType.SEQUENCE;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Event {
    public static final String SEQUENCE_NAME = "EVENT_ID_GENERATE";
    @Id
    @Column(name = "identificador")
//    @SequenceGenerator(
//            name = SEQUENCE_NAME,
//            sequenceName = SEQUENCE_NAME + "_bd",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = SEQUENCE,
//            generator = SEQUENCE_NAME
//    )
    private Long id;

    @Column(name = "Nome", length = 50, nullable = false)
    private String nome;
    @Column(name = "Descrição", length = 200, nullable = false)
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Boolean gratuito;
    @Column(name = "Local", length = 100, nullable = false)
    private String local;

}
