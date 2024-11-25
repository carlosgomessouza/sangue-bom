package com.example.sangue_bom.service;

import com.example.sangue_bom.model.Agenda;
import com.example.sangue_bom.model.DonationSummary;
import com.example.sangue_bom.repository.AgendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    public List<Agenda> findByUserId(long userId) {
        return agendaRepository.findByUserId(userId);
    }


    public Optional<Agenda> findById(Long id) {
        return agendaRepository.findById(id);
    }

    public Agenda save(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public DonationSummary getDoacaoSummaryByUserId(Long userId) {
        Pageable pageable = PageRequest.of(0, 1); // Primeira página, com 1 registro
        return agendaRepository.findDoacaoSummaryByUserId(userId, pageable)
                .stream()
                .findFirst() // Garante que retorna apenas 1 registro
                .map((result) ->{
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                            // Convertendo a string para LocalDate
                            LocalDate dateInicial = LocalDate.parse((String)result[2], formatter);  // 1 de janeiro de 2023

                    // Data atual
                    LocalDate dateNow = LocalDate.now();

                    // Calculando a diferença em meses
                    long mesesPassados = ChronoUnit.MONTHS.between(dateInicial, dateNow);
                           return new DonationSummary(
                                    (String) result[0],
                                    (Long) result[1],
                                    (String) result[2],
                                    mesesPassados
                            );
                }


                )
                .orElse(null);
    }
}
