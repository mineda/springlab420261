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
@Table(name = "rev_revisao")
public class Revisao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rev_id")
    @JsonView({View.Revisao.class})
    private Long id;

    @Column(name = "rev_feedback")
    @JsonView({View.Revisao.class})
    private String feedback;

    @Column(name = "rev_nota")
    @JsonView({View.Revisao.class})
    private Integer nota;

    @Column(name = "rev_data_revisao")
    @JsonView({View.Revisao.class})
    private LocalDate dataRevisao;

    @Column(name = "rev_data_leitura")
    @JsonView({View.Revisao.class})
    private LocalDate dataLeitura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rev_capitulo")
    @JsonView({View.Revisao.class})
    private Capitulo capitulo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public LocalDate getDataRevisao() {
        return dataRevisao;
    }

    public void setDataRevisao(LocalDate dataRevisao) {
        this.dataRevisao = dataRevisao;
    }

    public LocalDate getDataLeitura() {
        return dataLeitura;
    }

    public void setDataLeitura(LocalDate dataLeitura) {
        this.dataLeitura = dataLeitura;
    }

    public Capitulo getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
    }
    
}
