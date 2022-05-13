package com.luanda.zappts.desafio.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class JogadorTest {

    Jogador jogador = new Jogador();

    @Before
    public void setUp(){
        jogador.setUsuario("Maria");
        jogador.setSenha("123");
    }

    @Test
    public void testUsuario(){
        assertEquals("Maria", jogador.getUsuario());
    }

    @Test
    public void testSenha(){
        assertEquals("123", jogador.getSenha());
    }
}
