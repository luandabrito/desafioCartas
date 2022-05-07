package com.luanda.zappts.desafio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
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
    @ManyToOne()
    @JoinColumn(name = "listaId")
    private Lista lista;

}
