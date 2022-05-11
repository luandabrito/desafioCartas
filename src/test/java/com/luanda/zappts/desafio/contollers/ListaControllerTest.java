package com.luanda.zappts.desafio.contollers;

import com.luanda.zappts.desafio.builders.ListaBuilder;
import com.luanda.zappts.desafio.controllers.ListaController;
import com.luanda.zappts.desafio.domain.Carta;
import com.luanda.zappts.desafio.domain.Lista;
import com.luanda.zappts.desafio.service.ListaService;
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
public class ListaControllerTest {

    @InjectMocks
    ListaController listaController;

    @Mock
    ListaService listaService;

    private static Lista lista = ListaBuilder.umaLista().agora();
    private static List<Lista> listaCartas = new ArrayList<>();

    @Test
    public void deveCriarListaComSucesso() throws Exception {
        when(listaService.criarLista(lista)).thenReturn(lista);
        listaController.criarLista(lista);
        verify(listaService, times(1)).criarLista(lista);
    }

    @Test(expected = Exception.class)
    public void naoDeveSalvarCarta() throws Exception {
        when(listaService.criarLista(lista)).thenThrow(Exception.class);
        listaController.criarLista(lista);
    }

    @Test
    public void pegarTodasListasComSucesso() throws Exception {
        listaCartas.add(lista);
        when(listaService.pegarTodasListas()).thenReturn(listaCartas);
        listaController.pegarTodasListas();

        verify(listaService,times(1)).pegarTodasListas();
    }

    @Test
    public void pegarUmaListaComSucesso(){
        when(listaService.pegarUmaLista(any())).thenReturn(lista);
        Lista retorno = listaController.pegarUmaLista(any());

        verify(listaService, times(1)).pegarUmaLista(any());
        assertEquals(lista.getNome(), retorno.getNome());
    }
}
