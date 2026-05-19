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
@Table(name = "cor_correcao")
public class Correcao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cor_id")
    @JsonView({View.Correcao.class})
    private Long id;

    @Column(name = "cor_texto_antigo")
    @JsonView({View.Correcao.class})
    private String textoAntigo;

    @Column(name = "cor_texto_novo")
    @JsonView({View.Correcao.class})
    private String textoNovo;

    @Column(name = "cor_data_hora")
    @JsonView({View.Correcao.class})
    private LocalDateTime dataHora;

    @Column(name = "cor_motivo")
    @JsonView({View.Correcao.class})
    private String motivo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cor_anotacao")
    @JsonView({View.Correcao.class})
    private Anotacao anotacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextoAntigo() {
        return textoAntigo;
    }

    public void setTextoAntigo(String textoAntigo) {
        this.textoAntigo = textoAntigo;
    }

    public String getTextoNovo() {
        return textoNovo;
    }

    public void setTextoNovo(String textoNovo) {
        this.textoNovo = textoNovo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Anotacao getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(Anotacao anotacao) {
        this.anotacao = anotacao;
    }
    
}
