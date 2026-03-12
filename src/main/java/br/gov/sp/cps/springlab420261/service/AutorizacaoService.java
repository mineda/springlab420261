package br.gov.sp.cps.springlab420261.service;

import java.util.List;

import br.gov.sp.cps.springlab420261.entity.Autorizacao;

public interface AutorizacaoService {

    public Autorizacao buscarPorId(Long id);

    public List<Autorizacao> listar();
    
}
