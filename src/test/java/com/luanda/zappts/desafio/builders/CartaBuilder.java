package com.luanda.zappts.desafio.builders;

import com.luanda.zappts.desafio.domain.Carta;
import com.luanda.zappts.desafio.domain.Lista;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CartaBuilder {

    private Carta carta;

    public static CartaBuilder umaCarta(){
        CartaBuilder builder = new CartaBuilder();
        builder.carta = new Carta();
        builder.carta.setNome("Fogo");
        builder.carta.setEdicao(2);
        builder.carta.setIdioma("Portugues");
        builder.carta.setFoil(true);
        builder.carta.setPreco("R$2.000,00");
        builder.carta.setQuantidade(1);
        builder.carta.setLista(new Lista());
        return builder;
    }

    public static CartaBuilder umaCartaAtualizada(){
        CartaBuilder builder = new CartaBuilder();
        builder.carta = new Carta();
        builder.carta.setNome("Fogo");
        builder.carta.setEdicao(2);
        builder.carta.setIdioma("Portugues");
        builder.carta.setFoil(true);
        builder.carta.setPreco("R$2.000,00");
        builder.carta.setQuantidade(2);
        builder.carta.setLista(new Lista());
        return builder;
    }

    public static CartaBuilder umaCartaNomeNull(){
        CartaBuilder builder = new CartaBuilder();
        builder.carta = new Carta();
        builder.carta.setEdicao(2);
        builder.carta.setIdioma("Portugues");
        builder.carta.setFoil(true);
        builder.carta.setPreco("R$2.000,00");
        builder.carta.setQuantidade(1);
        return builder;
    }

    public Carta agora(){
        return carta;
    }

}
