package br.gov.sp.cps.springlab420261.service;

import java.util.List;

import br.gov.sp.cps.springlab420261.entity.Anotacao;

public interface AnotacaoService {

    public Anotacao buscarPorId(Long id);

    public List<Anotacao> buscarTodos();
    
}
