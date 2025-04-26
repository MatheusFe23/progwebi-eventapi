package br.ueg.progwebi.eventapi.service.impl;

import br.ueg.progwebi.eventapi.controller.exceptions.ResourceNotFound;
import br.ueg.progwebi.eventapi.model.Event;
import br.ueg.progwebi.eventapi.repository.EventRepository;
import br.ueg.progwebi.eventapi.service.EventService;
import br.ueg.progwebi.eventapi.service.exceptions.BusinessException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event create(Event event) {
        validations(event);
        validationsDate(event);
        return eventRepository.save(event);
    }

    private void validations(Event event) {
        if(Strings.isEmpty(event.getNome())){
            throw new BusinessException("Name não pode ser nulo ou vazio");
        }
        // Criar validação
    }
    private void validationsDate(Event event) {
     if(event.getDataInicio().isBefore(LocalDate.now())){
        throw new BusinessException("A data não pode ser antes da data atual");
       }
    }

    @Override
    public Event update(Long id, Event event) {
        Event eventToUpdate = this.getById(id);
        validationsDate(event);
        if (Strings.isEmpty(event.getNome())) {
            throw new BusinessException(("Dados incompletos"));
        }
        eventToUpdate.setNome(event.getNome());
        eventToUpdate.setDescricao(event.getDescricao());
        eventToUpdate.setDataInicio(event.getDataInicio());
        eventToUpdate.setDataFim(event.getDataFim());
        eventToUpdate.setGratuito(event.getGratuito());
        eventToUpdate.setLocal(event.getLocal());
        return eventRepository.save(eventToUpdate);
    }

    @Override
    public Event getById(Long id) {
        Optional<Event> event = this.eventRepository.findById(id);
        if (Boolean.FALSE.equals(event.isPresent())) {
            throw new BusinessException("Evento id:" +id+" não encontrado",404);
        } else{
            return event.get();
        }
    }

    @Override
    public Event delete(Long id) {
      Event event = this.getById(id);
      try{
          this.eventRepository.delete(event);
      } catch(DataIntegrityViolationException e){
          throw new BusinessException("Event id:" +id+"não pode ser removido,"+"por questões de integredidade");
      }
      return event;
    }


}
