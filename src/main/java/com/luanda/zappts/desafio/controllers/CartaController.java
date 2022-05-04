package com.luanda.zappts.desafio.controllers;

import com.luanda.zappts.desafio.entities.Carta;
import com.luanda.zappts.desafio.repositories.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartas")
public class CartaController {

    @Autowired
    CartaRepository cartaRepository;

    @PostMapping
    public void salvarCarta(@RequestBody Carta carta){

        cartaRepository.save(carta);

    }

}
