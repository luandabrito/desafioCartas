package com.luanda.zappts.desafio.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Carta implements Serializable {
    private static final long serialVersionUID = 1L;

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
