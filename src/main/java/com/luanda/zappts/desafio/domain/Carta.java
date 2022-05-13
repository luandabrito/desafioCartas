package com.luanda.zappts.desafio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "O campo nome não pode ser nulo")
    @JsonProperty("nome")
    private String nome;

    @NotNull(message = "O campo edicao não pode ser nulo")
    @JsonProperty("edicao")
    private Integer edicao;

    @NotNull(message = "O campo idioma não pode ser nulo")
    @JsonProperty("idioma")
    private String idioma;

    @NotNull(message = "O campo foil não pode ser nulo")
    @JsonProperty("foil")
    private Boolean foil;

    @NotNull(message = "O campo preco não pode ser nulo")
    @JsonProperty("preco")
    private String preco;

    @NotNull(message = "O campo quantidade não pode ser nulo")
    @JsonProperty("quantidade")
    private Integer quantidade;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "listaId")
    private Lista lista;

    @Override
    public boolean equals(Object o) {
        if (o instanceof Carta) {
            Carta qualquer = (Carta) o;
            return this.nome.equals(qualquer.getNome())
                    && this.edicao.equals(qualquer.getEdicao())
                    && this.idioma.equals(qualquer.getIdioma())
                    && this.foil.equals(qualquer.getFoil())
                    && this.preco.equals(qualquer.getPreco())
                    && this.quantidade.equals(qualquer.getQuantidade());
        }else {
            return false;
        }
    }

}
