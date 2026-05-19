package br.gov.sp.cps.springlab420261.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.cps.springlab420261.entity.Correcao;

public interface CorrecaoRepository extends JpaRepository<Correcao, Long> {

    public List<Correcao> findByAnotacaoTextoContainingIgnoreCaseAndDataHoraLessThan(String textoAnotacao, LocalDateTime dataHora);
    
}
