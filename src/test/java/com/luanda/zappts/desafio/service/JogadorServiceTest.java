package com.luanda.zappts.desafio.service;

import com.luanda.zappts.desafio.builders.JogadorBuilder;
import com.luanda.zappts.desafio.domain.Jogador;
import com.luanda.zappts.desafio.domain.JogadorResponse;
import com.luanda.zappts.desafio.repositories.JogadorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JogadorServiceTest {

    @InjectMocks
    JogadorService jogadorService;

    @Mock
    JogadorRepository jogadorRepository;

    private static Jogador jogador = JogadorBuilder.umJogador().agora();
    private static JogadorResponse jogadorResponse = JogadorResponse.builder().usuario("Maria").build();

    @Test
    public void criarJogadorComSucesso(){
        when(jogadorRepository.save(jogador)).thenReturn(jogador);
        JogadorResponse retorno = jogadorService.criarJogador(jogador);

        verify(jogadorRepository, times(1)).save(jogador);
        assertEquals(jogadorResponse.getUsuario(), retorno.getUsuario());
    }

    @Test
    public void pegarUmJogadorComSucesso(){
        when(jogadorRepository.findByUsuario(jogador.getUsuario())).thenReturn(jogador);
        JogadorResponse retorno = jogadorService.pegarUmJogador(jogador.getUsuario());

        verify(jogadorRepository, times(1)).findByUsuario(jogador.getUsuario());
        assertEquals(jogadorResponse.getUsuario(), retorno.getUsuario());

    }
}
