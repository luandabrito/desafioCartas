package com.luanda.zappts.desafio.controllers;

import com.luanda.zappts.desafio.domain.Jogador;
import com.luanda.zappts.desafio.domain.JogadorResponse;
import com.luanda.zappts.desafio.service.JogadorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping
    public JogadorResponse pegarUmJogador(@RequestParam String usuario){
        try {
            logger.info("Iniciando resgate do jogador: {}", usuario);
            JogadorResponse resposta = jogadorService.pegarUmJogador(usuario);
            logger.info("Jogador Resgatado com sucesso.");
            return resposta;
        } catch (ResponseStatusException e) {
            logger.error("Erro ao resgatar jogador.", e);
            throw new ResponseStatusException(e.getStatus(), "Erro ao resgatar jogador: " + e.getMessage());
        }
    }


}
