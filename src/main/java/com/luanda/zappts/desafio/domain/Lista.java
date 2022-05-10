package com.luanda.zappts.desafio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("nome")
    private String nome;

    @JsonManagedReference
    @OneToMany(mappedBy = "lista")
    private List<Carta> cartas = new ArrayList<>();

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "jogadorId")
    private Jogador jogador;
}
