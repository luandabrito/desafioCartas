package com.luanda.zappts.desafio.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ListaTest {

    Lista lista = new Lista();

    @Before
    public void setUp(){
        lista.setNome("Fogo");
    }

    @Test
    public void testNome(){
        assertEquals("Fogo", lista.getNome());
    }
}
