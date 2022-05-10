package com.luanda.zappts.desafio.builders;

import com.luanda.zappts.desafio.domain.Jogador;
import com.luanda.zappts.desafio.domain.JogadorResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JogadorBuilder {

    private Jogador jogador;

    private JogadorResponse jogadorResponse;

    public static JogadorBuilder umJogador(){
        JogadorBuilder builder = new JogadorBuilder();
        builder.jogador = new Jogador();
        builder.jogador.setUsuario("Maria");
        builder.jogador.setSenha("123");
        return builder;
    }

    public Jogador agora(){
        return jogador;
    }

    public static JogadorBuilder umJogadorResponse(){
        JogadorBuilder builder = new JogadorBuilder();
        builder.jogador = new Jogador();
        builder.jogador.setUsuario("Maria");
        return builder;
    }

    public JogadorResponse agoraResponse(){
        return jogadorResponse;
    }


}
