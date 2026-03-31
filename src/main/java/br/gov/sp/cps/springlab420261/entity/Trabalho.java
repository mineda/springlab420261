package br.gov.sp.cps.springlab420261.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.cps.springlab420261.controller.View;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tra_trabalho")
public class Trabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tra_id")
    @JsonView(View.Trabalho.class)
    private Long id;

    @Column(name = "tra_titulo")
    @JsonView(View.Trabalho.class)
    private String titulo;

    @Column(name = "tra_data_hora_entrega")
    @JsonView(View.Trabalho.class)
    private LocalDateTime dataHoraEntrega;

    @Column(name = "tra_descricao")
    @JsonView(View.Trabalho.class)
    private String descricao;

    @Column(name = "tra_nota")
    @JsonView(View.Trabalho.class)
    private Integer nota;

    @ManyToOne
    @JoinColumn(name = "tra_usr_id")
    @JsonView(View.Trabalho.class)
    private Usuario autor;

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

    public LocalDateTime getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Usuario getAutor() {
        return autor;
    } 

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

}