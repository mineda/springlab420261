package br.gov.sp.cps.springlab420261.service;

import java.util.List;

import br.gov.sp.cps.springlab420261.entity.Trabalho;

public interface TrabalhoService {

    public List<Trabalho> listar();

    public Trabalho cadastrar(Trabalho trabalho);

    public List<Trabalho> buscarPorTituloENomeAutor(String titulo, String nomeAutor);
    
}
