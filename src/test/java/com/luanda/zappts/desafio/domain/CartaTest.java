package com.luanda.zappts.desafio.domain;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class CartaTest {

    Carta carta = new Carta();

    @Before
    public void setUp(){
        carta.setNome("Fogo");
        carta.setEdicao(2);
        carta.setIdioma("Portugues");
        carta.setFoil(true);
        carta.setPreco("R$2.000,00");
        carta.setQuantidade(2);
    }

    @Test
    public void testDomain(){
        assertNotNull(carta.getNome());
        assertNotNull(carta.getEdicao());
        assertNotNull(carta.getIdioma());
        assertNotNull(carta.getFoil());
        assertNotNull(carta.getPreco());
        assertNotNull(carta.getQuantidade());
    }

}
