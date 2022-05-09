package com.luanda.zappts.desafio.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class JogadorResponse {

    @JsonProperty("codUsuario")
    private String usuario;

    @JsonProperty("listas")
    private List<Lista> listas = new ArrayList<>();
}
