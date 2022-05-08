package com.luanda.zappts.desafio.service;

import com.luanda.zappts.desafio.entities.Lista;
import com.luanda.zappts.desafio.repositories.ListaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    public List<Lista> pegarTodasListas() {
        List<Lista> response = listaRepository.findAll();
        return response;
    }

    public Lista pegarUmaLista(Integer id) {
        return listaRepository.findById(id)
                .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista não localizada"));
    }
}
