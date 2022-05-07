package com.luanda.zappts.desafio.controllers;

import com.luanda.zappts.desafio.entities.Lista;
import com.luanda.zappts.desafio.service.ListaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listas")
public class ListaController {

    @Autowired
    ListaService listaService;

    private static final Logger logger = LoggerFactory.getLogger(ListaController.class);

    @PostMapping
    public Lista criarLista(@RequestBody Lista lista) throws Exception {
        Lista response = null;

        try {
            logger.info("Iniciando criação de lista");
            response = listaService.criarLista(lista);
        } catch (Exception e) {
            throw new Exception("Erro ao criar lista: " + e.getMessage());
        }

        return response;
    }

    @GetMapping
    public List<Lista> pegarTodasListas(){
        List<Lista> response = null;

        try {
            logger.info("Iniciando resgate das listas");
            response =  listaService.pegarTodasListas();
        } catch (Exception e) {
            logger.error("Erro ao resgatar listas: {}", e.getMessage());
        }
       return response;
    }

}
