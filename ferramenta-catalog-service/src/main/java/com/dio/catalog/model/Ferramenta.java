package com.dio.catalog.model;

import jakarta.persistence.*;

@Entity
public class Ferramenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private EstadoFerramenta estado = EstadoFerramenta.DISPONIVEL;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaFerramenta categoria;

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

    public EstadoFerramenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoFerramenta estado) {
        this.estado = estado;
    }

    public CategoriaFerramenta getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaFerramenta categoria) {
        this.categoria = categoria;
    }
}
