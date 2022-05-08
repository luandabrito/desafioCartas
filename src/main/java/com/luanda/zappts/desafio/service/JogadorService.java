package com.luanda.zappts.desafio.service;

import com.luanda.zappts.desafio.entities.Jogador;
import com.luanda.zappts.desafio.entities.JogadorResponse;
import com.luanda.zappts.desafio.entities.Lista;
import com.luanda.zappts.desafio.repositories.JogadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadorService {

    @Autowired
    JogadorRepository jogadorRepository;

    private static final Logger logger = LoggerFactory.getLogger(JogadorService.class);

    public JogadorResponse criarJogador(Jogador jogador){
        Jogador resposta = jogadorRepository.save(jogador);
        logger.info("Jogador criado com sucesso");
        return JogadorResponse
                .builder()
                .id(resposta.getId())
                .usuario(resposta.getUsuario())
                .listas(resposta.getListas())
                .build();
    }
}
