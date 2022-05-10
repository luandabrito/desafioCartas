package com.luanda.zappts.desafio.contollers;

import com.luanda.zappts.desafio.builders.JogadorBuilder;
import com.luanda.zappts.desafio.controllers.JogadorController;
import com.luanda.zappts.desafio.domain.Jogador;
import com.luanda.zappts.desafio.domain.JogadorResponse;
import com.luanda.zappts.desafio.service.JogadorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JogadorControllerTest {

    @InjectMocks
    JogadorController jogadorController;

    @Mock
    JogadorService jogadorService;

    private static Jogador jogador = JogadorBuilder.umJogador().agora();
    private static JogadorResponse jogadorResponse = JogadorResponse.builder().usuario("Maria").build();

    @Test
    public void criarJogadorComSucesso() throws Exception {
        when(jogadorService.criarJogador(jogador)).thenReturn(jogadorResponse);
        JogadorResponse retorno = jogadorController.criarJogador(jogador);

        verify(jogadorService, times(1)).criarJogador(jogador);
        assertEquals(jogadorResponse.getUsuario(), retorno.getUsuario());
    }

    @Test(expected = Exception.class)
    public void naoDeveCriarJogador() throws Exception {
        when(jogadorService.criarJogador(jogador)).thenThrow(Exception.class);
        JogadorResponse retorno = jogadorController.criarJogador(jogador);
    }

}
