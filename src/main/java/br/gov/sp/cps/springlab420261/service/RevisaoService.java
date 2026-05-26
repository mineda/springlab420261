package br.gov.sp.cps.springlab420261.service;

import java.time.LocalDate;
import java.util.List;

import br.gov.sp.cps.springlab420261.entity.Revisao;

public interface RevisaoService {

    public List<Revisao> buscarPorTrabalhoEData(String tituloTrabalho, LocalDate dataRevisao); 

    public List<Revisao> buscarTodas();

    public Revisao buscarPorId(Long id);

    public Revisao cadastrar(Revisao revisao);
    
}
