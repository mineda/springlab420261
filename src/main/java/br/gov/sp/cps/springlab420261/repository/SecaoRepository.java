package br.gov.sp.cps.springlab420261.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.cps.springlab420261.entity.Secao;


public interface SecaoRepository extends JpaRepository<Secao, Long> {

    public List<Secao> findByCapituloTituloContainingIgnoreCaseAndDataAprovacaoGreaterThan(String titulo, LocalDate dataAprovacao);
    
}
