package br.gov.sp.cps.springlab420261.service;

import java.time.LocalDate;
import java.util.List;

import br.gov.sp.cps.springlab420261.entity.Secao;

public interface SecaoService {

    public Secao cadastrar(Secao secao);

    public List<Secao> buscarTodas();

    public Secao buscarPorId(Long id);

    public List<Secao> buscarPorTituloCapituloEDataAprovacao(String titulo, LocalDate dataAprovacao);
    
}
