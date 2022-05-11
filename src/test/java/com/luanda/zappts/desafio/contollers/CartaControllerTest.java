package com.luanda.zappts.desafio.contollers;

import com.luanda.zappts.desafio.builders.CartaBuilder;
import com.luanda.zappts.desafio.controllers.CartaController;
import com.luanda.zappts.desafio.domain.Carta;
import com.luanda.zappts.desafio.service.CartaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CartaControllerTest {

    @InjectMocks
    CartaController cartaController;

    @Mock
    CartaService cartaService;

    private static Carta carta = CartaBuilder.umaCarta().agora();
    private static Carta cartaNomeNull = CartaBuilder.umaCartaNomeNull().agora();

    @Test
    public void salvarCartaComSucesso() throws Exception {
        when(cartaService.salvarCarta(carta)).thenReturn(carta);
        Carta retorno = cartaController.salvarCarta(carta);

        verify(cartaService, times(1)).salvarCarta(carta);
        assertEquals(carta.getNome(), retorno.getNome());
        assertEquals(carta.getEdicao(), retorno.getEdicao());
        assertEquals(carta.getIdioma(), retorno.getIdioma());
        assertEquals(carta.getFoil(), retorno.getFoil());
        assertEquals(carta.getPreco(), retorno.getPreco());
        assertEquals(carta.getQuantidade(), retorno.getQuantidade());

    }

    @Test(expected = Exception.class)
    public void naoDeveSalvarCartaNomeNull() throws Exception {
        when(cartaService.salvarCarta(cartaNomeNull)).thenThrow(Exception.class);
        cartaController.salvarCarta(cartaNomeNull);
    }

    @Test
    public void deletarCartaComSucesso() throws Exception {
        cartaController.deletarCarta(any(), any(), any());
        verify(cartaService, times(1)).deletarCarta(any(),any(),any());
    }

    @Test
    public void atualizarCartaComSucesso() throws Exception {
        cartaController.atualizarCarta(any(),any(), any(), any());
        verify(cartaService, times(1)).atualizarCarta(any(),any(),any(),any());
    }
}
