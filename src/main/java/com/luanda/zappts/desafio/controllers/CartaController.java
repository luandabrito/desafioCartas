package com.luanda.zappts.desafio.controllers;

import com.luanda.zappts.desafio.entities.Carta;
import com.luanda.zappts.desafio.service.CartaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/cartas")
public class CartaController {

    @Autowired
    CartaService cartaService;

    private static final Logger logger = LoggerFactory.getLogger(CartaController.class);

    @PostMapping
    public Carta salvarCarta(@RequestBody Carta carta) throws Exception {
        Carta response = null;

        try {
            logger.info("Iniciando salvamento da carta");
            response = cartaService.salvarCarta(carta);
        } catch (Exception e) {
            throw new Exception("Erro ao salvar carta: " + e.getMessage());
        }
        return response;

    }

    @DeleteMapping("{id}")
    public void deletarCarta(@PathVariable Integer id){
        cartaService.deletarCarta(id);

    }

}
