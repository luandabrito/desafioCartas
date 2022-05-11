package com.luanda.zappts.desafio.service;

import com.luanda.zappts.desafio.builders.ListaBuilder;
import com.luanda.zappts.desafio.domain.Lista;
import com.luanda.zappts.desafio.repositories.ListaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ListaServiceTest {

    @InjectMocks
    ListaService listaService;

    @Mock
    ListaRepository listaRepository;

    private static Lista lista = ListaBuilder.umaLista().agora();
    private static List<Lista> listaCartas = new ArrayList<>();

    @Test
    public void criarListaComSucesso(){
        when(listaRepository.save(lista)).thenReturn(lista);
        Lista retorno = listaService.criarLista(lista);

        verify(listaRepository, times(1)).save(lista);
        assertEquals(lista.getNome(), retorno.getNome());
    }

    @Test
    public void pegarTodasListasComSucesso(){
        listaCartas.add(lista);
        when(listaRepository.findAll()).thenReturn(listaCartas);
        List<Lista> retorno = listaService.pegarTodasListas();

        verify(listaRepository, times(1)).findAll();
        assertEquals(listaCartas.get(0).getNome(), retorno.get(0).getNome());
    }

    @Test
    public void pegarUmaListaComSucesso(){
        when(listaRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(lista));
        Lista retorno = listaService.pegarUmaLista(any());

        verify(listaRepository, times(1)).findById(any());
        assertEquals(lista.getNome(), retorno.getNome());

    }
}
