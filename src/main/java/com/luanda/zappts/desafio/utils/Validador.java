package com.luanda.zappts.desafio.utils;

import com.luanda.zappts.desafio.entities.Carta;
import com.luanda.zappts.desafio.entities.Lista;
import com.luanda.zappts.desafio.repositories.ListaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.luanda.zappts.desafio.utils.Constantes.VALIDANDO;

@Service
public class Validador {

    @Autowired
    ListaRepository listaRepository;

    private static final Logger logger = LoggerFactory.getLogger(Validador.class);

    public void validarValor(String preco) throws Exception {
        logger.info(VALIDANDO, preco);
        if (!preco.matches("^R\\$([1-9]\\d{0,2}((\\.\\d{3})*|\\d*))(\\,\\d{2})?$")){
            throw new Exception("Campo inválido" + preco);
        }
    }

}
