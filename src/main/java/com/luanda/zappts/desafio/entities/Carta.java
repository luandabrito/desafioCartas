package com.luanda.zappts.desafio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import javax.persistence.*;

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

    @JsonBackReference
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "lista_id")
    @JsonProperty("lista")
    private Lista lista;

}
