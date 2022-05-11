package com.luanda.zappts.desafio.builders;

import com.luanda.zappts.desafio.domain.Jogador;
import com.luanda.zappts.desafio.domain.Lista;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class ListaBuilder {

    private Lista lista;

    public static ListaBuilder umaLista(){
        ListaBuilder builder = new ListaBuilder();
        builder.lista = new Lista();
        builder.lista.setNome("Fogo");
        builder.lista.setCartas(new ArrayList<>());
        builder.lista.setJogador(new Jogador());
        return builder;
    }

    public Lista agora(){
        return lista;
    }
}
