package com.luanda.zappts.desafio.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class JogadorResponse {

    @JsonProperty("codUsuario")
    private String usuario;

    @JsonProperty("listas")
    private List<Lista> listas = new ArrayList<>();
}
