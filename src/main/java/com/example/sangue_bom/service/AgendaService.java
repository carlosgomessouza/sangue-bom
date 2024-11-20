package com.example.sangue_bom.service;

import com.example.sangue_bom.model.Agenda;
import com.example.sangue_bom.model.User;
import com.example.sangue_bom.repository.AgendaRepository;
import com.example.sangue_bom.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    public Optional<Agenda> findById(Long id) {
        return agendaRepository.findById(id);
    }

    public Agenda save(Agenda agenda) {
        return agendaRepository.save(agenda);
    }
}
