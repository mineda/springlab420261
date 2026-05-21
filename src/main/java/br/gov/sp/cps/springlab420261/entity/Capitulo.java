package br.gov.sp.cps.springlab420261.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.cps.springlab420261.controller.View;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cap_capitulo")
public class Capitulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cap_id")
    @JsonView({View.Capitulo.class, View.Secao.class})
    private Long id;

    @Column(name = "cap_titulo")
    @JsonView({View.Capitulo.class, View.Secao.class})
    private String titulo;

    @Column(name = "cap_conteudo")
    @JsonView({View.Capitulo.class, View.Secao.class})
    private String conteudo;

    @Column(name = "cap_data_criacao")
    @JsonView({View.Capitulo.class, View.Secao.class})
    private LocalDate dataCriacao;

    @Column(name = "cap_data_entrega")
    @JsonView({View.Capitulo.class, View.Secao.class})
    private LocalDate dataEntrega;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cap_trabalho")
    @JsonView({View.Capitulo.class})
    private Trabalho trabalho;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }
    
}
