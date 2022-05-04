package com.luanda.zappts.desafio.repositories;

import com.luanda.zappts.desafio.entities.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {
}
