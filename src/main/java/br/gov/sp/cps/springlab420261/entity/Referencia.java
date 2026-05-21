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
@Table(name = "ref_referencia")
public class Referencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ref_id")
    @JsonView({View.Referencia.class})
    private Long id;

    @Column(name = "ref_descricao")
    @JsonView({View.Referencia.class})
    private String descricao;

    @Column(name = "ref_link")
    @JsonView({View.Referencia.class})
    private String link;

    @Column(name = "ref_ano")
    @JsonView({View.Referencia.class})
    private Integer ano;

    @Column(name = "ref_data_acesso")
    @JsonView({View.Referencia.class})
    private LocalDate dataAcesso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ref_secao")
    @JsonView({View.Referencia.class})
    private Secao secao;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public LocalDate getDataAcesso() {
        return dataAcesso;
    }

    public void setDataAcesso(LocalDate dataAcesso) {
        this.dataAcesso = dataAcesso;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }
    
}
