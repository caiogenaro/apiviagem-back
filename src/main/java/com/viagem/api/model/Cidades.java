package com.viagem.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cidades")
public class Cidades {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="nome_cidade")
    private String nome;

    @Column(name ="foto_cidade")
    private String foto;

    @Column(name ="valor_passagem")
    private Integer valor;


    @ManyToOne
    @JoinColumn(name ="id_cozinha")
    private Cozinha cozinha;

    @Transient
    private Integer media;
}
