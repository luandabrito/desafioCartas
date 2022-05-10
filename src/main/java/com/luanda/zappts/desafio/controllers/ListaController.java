package com.luanda.zappts.desafio.controllers;

import com.luanda.zappts.desafio.domain.Lista;
import com.luanda.zappts.desafio.service.ListaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/listas")
public class ListaController {

    @Autowired
    ListaService listaService;

    private static final Logger logger = LoggerFactory.getLogger(ListaController.class);

    @PostMapping
    public Lista criarLista(@RequestBody Lista lista) throws Exception {
        try {
            logger.info("Iniciando criação de lista");
            return listaService.criarLista(lista);
        } catch (Exception e) {
            throw new Exception("Erro ao criar lista: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Lista> pegarTodasListas() throws Exception{
        try {
            logger.info("Iniciando resgate das listas");
            return listaService.pegarTodasListas();
        } catch (Exception e) {
            throw new Exception("Erro ao resgatar listas: " + e.getMessage());
        }
    }

    @GetMapping("{id}")
    public Lista pegarUmaLista(@PathVariable Integer id){
        try {
            logger.info("Iniciando resgate da lista de id: {}", id);
            Lista resposta = listaService.pegarUmaLista(id);
            logger.info("Lista Resgatada com sucesso.");
            return resposta;
        } catch (ResponseStatusException e) {
            logger.error("Erro ao resgatar lista.", e);
            throw new ResponseStatusException(e.getStatus(), "Erro ao resgatar lista: " + e.getMessage());
        }
    }


}
