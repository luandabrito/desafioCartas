package com.luanda.zappts.desafio.controllers;

import com.luanda.zappts.desafio.entities.Jogador;
import com.luanda.zappts.desafio.entities.JogadorResponse;
import com.luanda.zappts.desafio.service.JogadorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    JogadorService jogadorService;

    private static final Logger logger = LoggerFactory.getLogger(JogadorController.class);

    @PostMapping
    public JogadorResponse criarJogador(@RequestBody Jogador jogador) throws Exception {
        try {
            logger.info("Iniciando criação de jogador");
            return jogadorService.criarJogador(jogador);
        } catch (Exception e) {
            throw new Exception("Erro ao criar jogador: " + e.getMessage());
        }
    }


}
