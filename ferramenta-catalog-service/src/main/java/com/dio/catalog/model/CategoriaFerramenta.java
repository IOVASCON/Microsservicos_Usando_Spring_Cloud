package com.dio.catalog.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORIA_FERRAMENTA") // Especifica o nome correto da tabela
public class CategoriaFerramenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Ferramenta> ferramentas;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Ferramenta> getFerramentas() {
        return ferramentas;
    }

    public void setFerramentas(List<Ferramenta> ferramentas) {
        this.ferramentas = ferramentas;
    }
}
