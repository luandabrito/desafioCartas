package com.luanda.zappts.desafio.domain;

import com.luanda.zappts.desafio.builders.CartaBuilder;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class CartaTest {

    Carta carta = CartaBuilder.umaCarta().agora();

    @Test
    public void testDomain(){
        assertNotNull(carta.getNome());
        assertNotNull(carta.getEdicao());
        assertNotNull(carta.getIdioma());
        assertNotNull(carta.getFoil());
        assertNotNull(carta.getPreco());
        assertNotNull(carta.getQuantidade());
        assertNotNull(carta.getLista());
    }

}
