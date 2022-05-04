package com.luanda.zappts.desafio.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@Entity
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("edicao")
    private Integer edicao;

    @JsonProperty("idioma")
    private String idioma;

    @JsonProperty("foil")
    private Boolean foil;

    @JsonProperty("preco")
    private Double preco;

    @JsonProperty("quantidade")
    private Integer quantidade;


}
