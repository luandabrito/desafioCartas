package com.luanda.zappts.desafio.controllers;

import com.luanda.zappts.desafio.entities.Carta;
import com.luanda.zappts.desafio.repositories.CartaRepository;
import com.luanda.zappts.desafio.service.CartaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartas")
public class CartaController {

    @Autowired
    CartaService cartaService;

    private static final Logger logger = LoggerFactory.getLogger(CartaController.class);

    @PostMapping
    public Carta salvarCarta(@RequestBody Carta carta){
        Carta response = null;

        try {
            logger.info("Iniciando salvamento da carta");
            response = cartaService.salvarCarta(carta);
        } catch (Exception e) {
            logger.error("Erro ao salvar carta: {}", e.getMessage());
        }
        return response;

    }

}
