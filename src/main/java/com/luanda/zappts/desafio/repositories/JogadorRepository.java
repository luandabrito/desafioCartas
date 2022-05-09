package com.luanda.zappts.desafio.repositories;

import com.luanda.zappts.desafio.entities.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

    public Jogador findByUsuario(String usuario);
}
