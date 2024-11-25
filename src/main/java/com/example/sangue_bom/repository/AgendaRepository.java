package com.example.sangue_bom.repository;

import com.example.sangue_bom.model.Agenda;
import com.example.sangue_bom.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    Agenda findByType(String type);

    List<Agenda> findByUserId(Long userId);

    @Query("""
    SELECT 
        a.type AS type,
        COUNT(a.id) AS donationQuantity,
        MAX(a.date) AS lastDonation
    FROM Agenda a
    WHERE a.user.id = :userId
    GROUP BY a.type
""")
    Page<Object[]> findDoacaoSummaryByUserId(@Param("userId") Long userId, Pageable pageable);


}
