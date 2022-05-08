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
        logger.info("Criando lista: {}", lista.toString());
        Lista resposta = listaRepository.save(lista);
        logger.info("Lista criada com sucesso: {}", resposta.toString());
        return resposta;
    }

    public List<Lista> pegarTodasListas() {
        logger.info("Resgatando todas as listas");
        List<Lista> resposta = listaRepository.findAll();
        logger.info("Listas resgatadas com sucesso");
        return resposta;
    }

    public Lista pegarUmaLista(Integer id) {
        logger.info("Resgatando a lista de id: {}", id);
        return listaRepository.findById(id)
                .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista não localizada"));
    }
}
