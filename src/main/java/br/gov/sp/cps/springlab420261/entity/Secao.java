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
@Table(name = "sec_secao")
public class Secao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sec_id")
    @JsonView({View.Secao.class, View.Referencia.class})
    private Long id;

    @Column(name = "sec_titulo")
    @JsonView({View.Secao.class, View.Referencia.class})
    private String titulo;

    @Column(name = "sec_conteudo")
    @JsonView({View.Secao.class, View.Referencia.class})
    private String conteudo;

    @Column(name = "sec_data_criacao")
    @JsonView({View.Secao.class, View.Referencia.class})
    private LocalDate dataCriacao;

    @Column(name = "sec_data_aprovacao")
    @JsonView({View.Secao.class, View.Referencia.class})
    private LocalDate dataAprovacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sec_capitulo")
    @JsonView({View.Secao.class})
    private Capitulo capitulo;

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

    public LocalDate getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(LocalDate dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public Capitulo getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
    }
    
}
