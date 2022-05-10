package com.luanda.zappts.desafio.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidadorTest {

    @InjectMocks
    Validador validador;

    @Test(expected = Exception.class)
    public void valorRealSemR() throws Exception {
        validador.validarValor("$2.000,00");
    }
}
