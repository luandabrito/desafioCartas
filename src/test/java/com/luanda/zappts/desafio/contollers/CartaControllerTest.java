package com.luanda.zappts.desafio.contollers;

import com.luanda.zappts.desafio.controllers.CartaController;
import com.luanda.zappts.desafio.controllers.JogadorController;
import com.luanda.zappts.desafio.service.CartaService;
import com.luanda.zappts.desafio.service.JogadorService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CartaControllerTest {

    @InjectMocks
    CartaController cartaController;

    @Mock
    CartaService cartaService;


}
