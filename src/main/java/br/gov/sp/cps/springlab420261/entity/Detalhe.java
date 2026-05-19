package br.gov.sp.cps.springlab420261.entity;

import java.time.LocalDateTime;

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
@Table(name = "det_detalhe")
public class Detalhe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "det_id")
    @JsonView({View.Detalhe.class})
    private Long id;

    @Column(name = "det_descricao")
    @JsonView({View.Detalhe.class})
    private String descricao;

    @Column(name = "det_data_hora")
    @JsonView({View.Detalhe.class})
    private LocalDateTime dataHora;

    @Column(name = "det_data_hora_alteracao")
    @JsonView({View.Detalhe.class})
    private LocalDateTime dataHoraAlteracao;

    @Column(name = "det_alcance")
    @JsonView({View.Detalhe.class})
    private Integer alcance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "det_anotacao")
    @JsonView({View.Detalhe.class})
    private Anotacao anotacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public LocalDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public Integer getAlcance() {
        return alcance;
    }

    public void setAlcance(Integer alcance) {
        this.alcance = alcance;
    }

    public Anotacao getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(Anotacao anotacao) {
        this.anotacao = anotacao;
    }
    
}
