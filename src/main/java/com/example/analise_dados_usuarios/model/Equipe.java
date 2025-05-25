package com.example.analise_dados_usuarios.model;

import java.util.List;

import lombok.Data;

@Data
public class Equipe {

    private String nome;
    private boolean lider;
    private List<Projeto> projetos;
}
