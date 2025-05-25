package com.example.analise_dados_usuarios.model;

import java.util.List;

import lombok.Data;

@Data
public class User {

    private String id;
    private String nome;
    private int idade;
    private int score;
    private boolean ativo;
    private String pais;
    private Equipe equipe;
    private List<Log> logs;

}