package com.luanda.zappts.desafio.service;

import com.luanda.zappts.desafio.controllers.CartaController;
import com.luanda.zappts.desafio.entities.Carta;
import com.luanda.zappts.desafio.repositories.CartaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CartaService {

    @Autowired
    CartaRepository cartaRepository;

    private static final Logger logger = LoggerFactory.getLogger(CartaService.class);

    public Carta salvarCarta(Carta carta){
        try {
            logger.info("Salvar carta: {}", carta.toString());
            Carta response = cartaRepository.save(carta);
            return response;
        } catch (Exception e) {
            System.out.println(e);
        }
        return carta;
    }

}
