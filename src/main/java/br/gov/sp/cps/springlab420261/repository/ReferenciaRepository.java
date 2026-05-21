package br.gov.sp.cps.springlab420261.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.cps.springlab420261.entity.Referencia;

public interface ReferenciaRepository extends JpaRepository<Referencia, Long> {

    public List<Referencia> findBySecaoTituloContainingIgnoreCaseAndDataAcessoLessThan(String titulo, LocalDate dataAcesso);
    
}
