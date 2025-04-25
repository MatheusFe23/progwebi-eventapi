package br.ueg.progwebi.eventapi.repository;

import br.ueg.progwebi.eventapi.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
