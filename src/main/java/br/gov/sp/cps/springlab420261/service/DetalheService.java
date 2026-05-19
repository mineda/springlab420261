package br.gov.sp.cps.springlab420261.service;

import java.util.List;

import br.gov.sp.cps.springlab420261.entity.Detalhe;

public interface DetalheService {

    public List<Detalhe> buscarDetalhesPorAnotacaoEAlcance(String textoAnotacao, Integer alcance);

    public List<Detalhe> buscarTodos();

    public Detalhe buscarPorId(Long id);

    public Detalhe cadastrar(Detalhe detalhe);
    
}
