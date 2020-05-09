package com.example.demo.model;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name = "enfermeiro")
public class EnfermeiroEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long registroClasse;
        @Column(name = "nome")
        private String nome;
        @Column(name = "idade")
        private int idade;
        @Column(name = "local")
        private String hospitalAtuacao;
    }
