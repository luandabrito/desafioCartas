package com.luanda.zappts.desafio.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Builder
public class JogadorResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("usuario")
    private String usuario;

    @JsonProperty("listas")
    private List<Lista> listas = new ArrayList<>();
}
