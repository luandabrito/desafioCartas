package com.luanda.zappts.desafio.service;

import com.luanda.zappts.desafio.domain.Carta;
import com.luanda.zappts.desafio.domain.Lista;
import com.luanda.zappts.desafio.repositories.CartaRepository;
import com.luanda.zappts.desafio.utils.Validador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static com.luanda.zappts.desafio.utils.Constantes.CARTA_NAO_LOCALIZADA;

@Service
public class CartaService {

    @Autowired
    CartaRepository cartaRepository;

    @Autowired
    ListaService listaService;

    @Autowired
    Validador validador;

    private static final Logger logger = LoggerFactory.getLogger(CartaService.class);

    public Carta salvarCarta(Carta carta) throws Exception {
        try {
            validador.validarValor(carta.getPreco());
            validarCarta(carta);
            logger.info("Salvando carta: {}", carta.toString());
            Carta resposta = cartaRepository.save(carta);
            logger.info("Carta salva com sucesso: {}", resposta);
            return resposta;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public void deletarCarta(Integer id, String usuario, String senha) throws Exception {
        if (validador.validarSenhaEUsuario(id, usuario, senha)) {
            logger.info("Deletando carta de id: {}", id);
            cartaRepository.findById(id)
                    .map(carta -> {
                        cartaRepository.delete(carta);
                        return Void.TYPE;
                    })
                    .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, CARTA_NAO_LOCALIZADA));
        } else {
            throw new Exception("Usuário e/ou senha incorretos");
        }
    }

    public void atualizarCarta(Integer id, Carta cartaAtualizada, String usuario, String senha) throws Exception {
        if (validador.validarSenhaEUsuario(id, usuario, senha)) {
            logger.info("Atualizando carta, id: {}, atualizações: preco: {}, quantidade: {}", id, cartaAtualizada.getPreco(), cartaAtualizada.getQuantidade());
            cartaRepository.findById(id).map(carta -> {
                if(cartaAtualizada.getPreco() != null)
                    carta.setPreco(cartaAtualizada.getPreco());
                if(cartaAtualizada.getQuantidade() != null)
                    carta.setQuantidade(cartaAtualizada.getQuantidade());
                return cartaRepository.save(carta);
            }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, CARTA_NAO_LOCALIZADA));
        } else {
            throw new Exception("Usuário e/ou senha incorretos");
        }
    }

    private void validarCarta(Carta carta) throws Exception {
        Lista lista = listaService.pegarUmaLista(carta.getLista().getId());
        logger.info("Validando se já existe carta salva com as mesmas caracteristicas.");

        for (Carta cartaSalva : lista.getCartas()) {
            if(carta.equals(cartaSalva)){
                throw new Exception("Carta já existe com id: " + cartaSalva.getId());
            }
        }
        logger.info("Carta validada com sucesso.");
    }

}
