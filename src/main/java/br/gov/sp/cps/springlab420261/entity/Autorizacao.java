package br.gov.sp.cps.springlab420261.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.cps.springlab420261.controller.View;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aut_autorizacao")
public class Autorizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    @JsonView({View.UsuarioCompleto.class, View.Autorizacao.class})
    private Long id;

    @Column(name = "aut_nome")
    @JsonView({View.UsuarioCompleto.class, View.Autorizacao.class})
    private String nome;

    @ManyToMany(mappedBy = "autorizacoes", fetch = FetchType.LAZY)
    @JsonView(View.Autorizacao.class)
    private Set<Usuario> usuarios;

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

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
}
