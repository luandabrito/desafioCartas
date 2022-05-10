package com.luanda.zappts.desafio.utils;

import com.luanda.zappts.desafio.domain.Carta;
import com.luanda.zappts.desafio.domain.Lista;
import com.luanda.zappts.desafio.repositories.CartaRepository;
import com.luanda.zappts.desafio.repositories.JogadorRepository;
import com.luanda.zappts.desafio.repositories.ListaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static com.luanda.zappts.desafio.utils.Constantes.*;

@Service
public class Validador {

    @Autowired
    ListaRepository listaRepository;

    @Autowired
    JogadorRepository jogadorRepository;

    @Autowired
    CartaRepository cartaRepository;

    private static final Logger logger = LoggerFactory.getLogger(Validador.class);

    public void validarValor(String preco) throws Exception {
        logger.info(VALIDANDO_CAMPO, preco);
        if (!preco.matches("^R\\$([1-9]\\d{0,2}((\\.\\d{3})*|\\d*))(\\,\\d{2})?$")){
            throw new Exception("Campo inválido" + preco);
        }
    }

    public Boolean validarSenhaEUsuario(Integer id, String usuario, String senha){
        logger.info(VALIDANDO_USUARIO_SENHA);
        Carta carta = cartaRepository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, CARTA_NAO_LOCALIZADA));
        Lista lista = listaRepository.findById(carta.getLista().getId()).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, LISTA_NAO_LOCALIZADA));
        if (lista.getJogador().getUsuario().equals(usuario) && lista.getJogador().getSenha().equals(senha)){
            return true;
        }
        return false;
    }

}
