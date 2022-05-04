package com.luanda.zappts.desafio.repositories;

import com.luanda.zappts.desafio.entities.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Integer> {
}
