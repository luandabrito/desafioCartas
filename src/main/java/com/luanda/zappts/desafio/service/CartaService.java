package com.luanda.zappts.desafio.service;

import com.luanda.zappts.desafio.entities.Carta;
import com.luanda.zappts.desafio.repositories.CartaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CartaService {

    @Autowired
    CartaRepository cartaRepository;

    private static final Logger logger = LoggerFactory.getLogger(CartaService.class);

    public Carta salvarCarta(Carta carta){
        logger.info("Salvar carta: {}", carta.toString());
        Carta response = cartaRepository.save(carta);

        return response;
    }

    public void deletarCarta(Integer id){
        logger.info("Deletando carta de id: {}", id);
        cartaRepository.findById(id)
                .map(carta -> {
                    cartaRepository.delete(carta);
                    return Void.TYPE;
                })
                .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carta não localizada"));
    }

    public void atualizarCarta(Integer id, Carta cartaAtualizada){
        logger.info("Atualizando carta, id: {}, atualizações: {}", id, cartaAtualizada);
        cartaRepository.findById(id).map(carta -> {
            if(cartaAtualizada.getPreco() != null)
                carta.setPreco(cartaAtualizada.getPreco());
            if(cartaAtualizada.getQuantidade() != null)
                carta.setQuantidade(cartaAtualizada.getQuantidade());
            return cartaRepository.save(carta);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carta não localizada"));
    }

}
