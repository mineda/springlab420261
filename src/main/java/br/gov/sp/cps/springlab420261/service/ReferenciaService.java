package br.gov.sp.cps.springlab420261.service;

import java.time.LocalDate;
import java.util.List;

import br.gov.sp.cps.springlab420261.entity.Referencia;

public interface ReferenciaService {

    public Referencia cadastrar(Referencia referencia);

    public List<Referencia> buscarTodas();

    public Referencia buscarPorId(Long id);

    public List<Referencia> buscarPorTituloSecaoEDataAcesso(String titulo, LocalDate dataAcesso);
    
}
