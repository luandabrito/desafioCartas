package com.luanda.zappts.desafio.service;

import com.luanda.zappts.desafio.builders.CartaBuilder;
import com.luanda.zappts.desafio.domain.Carta;
import com.luanda.zappts.desafio.repositories.CartaRepository;
import com.luanda.zappts.desafio.utils.Validador;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CartaServiceTest {

    @InjectMocks
    CartaService cartaService;

    @Mock
    CartaRepository cartaRepository;

    @Mock
    Validador validador;

    private static Carta carta = CartaBuilder.umaCarta().agora();
    private static Carta cartaAtualizada = CartaBuilder.umaCartaAtualizada().agora();

    @Test
    public void salvarCartaComSucesso() throws Exception {
        when(cartaRepository.save(carta)).thenReturn(carta);
        Carta retorno = cartaService.salvarCarta(carta);

        verify(cartaRepository, times(1)).save(carta);
        assertEquals(carta.getNome(), retorno.getNome());
    }

    @Test
    public void deletarCartaComSucesso() throws Exception {
        when(validador.validarSenhaEUsuario(any(),any(),any())).thenReturn(true);
        when(cartaRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(carta));
        cartaService.deletarCarta(any(), any(), any());

        verify(cartaRepository, times(1)).delete(carta);
    }

    @Test(expected = Exception.class)
    public void erroUsuarioESenha() throws Exception {
        when(validador.validarSenhaEUsuario(any(),any(),any())).thenReturn(false);
        cartaService.atualizarCarta(any(), cartaAtualizada, any(), any());
    }

}
