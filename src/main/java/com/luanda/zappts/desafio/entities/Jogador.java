package com.luanda.zappts.desafio.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("usuario")
    private String usuario;

    @JsonProperty("senha")
    private String senha;

    @JsonManagedReference
    @OneToMany(mappedBy = "jogador")
    private List<Lista> listas = new ArrayList<>();

}
