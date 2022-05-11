package com.luanda.zappts.desafio.domain;

import com.luanda.zappts.desafio.builders.ListaBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class ListaTest {

    Lista lista = ListaBuilder.umaLista().agora();

    @Test
    public void testNome(){
        assertNotNull(lista.getNome());
        assertNotNull(lista.getCartas());
        assertNotNull(lista.getJogador());
    }
}
