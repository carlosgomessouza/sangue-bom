package com.example.sangue_bom.repository;

import com.example.sangue_bom.model.Agenda;
import com.example.sangue_bom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    Agenda findByType(String type);

}