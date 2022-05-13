package com.luanda.zappts.desafio.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class JogadorResponseTest {

    JogadorResponse jogadorResponse = new JogadorResponse("Maria", new ArrayList<>());

    @Test
    public void testDomain(){
        assertNotNull(jogadorResponse.getUsuario());
        assertNotNull(jogadorResponse.getListas());

    }
}
