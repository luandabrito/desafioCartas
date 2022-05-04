package com.luanda.zappts.desafio.service;

import com.luanda.zappts.desafio.entities.Lista;
import com.luanda.zappts.desafio.repositories.ListaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaService {

    @Autowired
    ListaRepository listaRepository;

    private static final Logger logger = LoggerFactory.getLogger(ListaService.class);

    public Lista criarLista(Lista lista){

        logger.info("Criando Lista: {}", lista.toString());
        Lista response = listaRepository.save(lista);

        return response;
    }

}
