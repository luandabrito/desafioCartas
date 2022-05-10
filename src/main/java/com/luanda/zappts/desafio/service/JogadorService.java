package com.luanda.zappts.desafio.service;

import com.luanda.zappts.desafio.domain.Jogador;
import com.luanda.zappts.desafio.domain.JogadorResponse;
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
                .usuario(resposta.getUsuario())
                .listas(resposta.getListas())
                .build();
    }

    public JogadorResponse pegarUmJogador(String usuario) {
        logger.info("Resgatando jogador: {}", usuario);
        Jogador resposta = jogadorRepository.findByUsuario(usuario);
        return JogadorResponse
                .builder()
                .usuario(resposta.getUsuario())
                .listas(resposta.getListas())
                .build();
    }
}
