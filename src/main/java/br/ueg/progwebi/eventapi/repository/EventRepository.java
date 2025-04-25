package br.ueg.progwebi.eventapi.repository;

import br.ueg.progwebi.eventapi.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Evento, Long> {
}
