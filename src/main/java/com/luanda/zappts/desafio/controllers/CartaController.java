package com.luanda.zappts.desafio.controllers;

import com.luanda.zappts.desafio.domain.Carta;
import com.luanda.zappts.desafio.service.CartaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartas")
public class CartaController {

    @Autowired
    CartaService cartaService;

    private static final Logger logger = LoggerFactory.getLogger(CartaController.class);

    @PostMapping
    public Carta salvarCarta(@RequestBody Carta carta) throws Exception {
        try {
            logger.info("Iniciando o salvamento da carta");
            return cartaService.salvarCarta(carta);
        } catch (Exception e) {
            throw new Exception("Erro ao salvar carta: " + e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public void deletarCarta(@PathVariable Integer id, @RequestHeader String usuario, @RequestHeader String senha) throws Exception {
        try {
            logger.info("Iniciando remoção da carta id: {}", id);
            cartaService.deletarCarta(id, usuario, senha);
        } catch (Exception e) {
            throw new Exception("Erro ao deletar carta: " + e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> atualizarCarta(@PathVariable Integer id, @RequestBody Carta carta, @RequestHeader String usuario, @RequestHeader String senha) throws Exception {
        try {
            logger.info("Iniciando atualização da carta: {}", id);
            cartaService.atualizarCarta(id, carta, usuario, senha);
            return null;
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar carta: " + e.getMessage());
        }
    }

}
