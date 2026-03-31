package br.gov.sp.cps.springlab420261.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.cps.springlab420261.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{

    public List<Trabalho> findByTituloContainingIgnoreCaseAndAutorNomeContainingIgnoreCase(String titulo, String nomeAutor);

    @Query("select t from Trabalho t join t.autor a where lower(t.titulo) like lower(concat('%', :titulo, '%')) and lower(a.nome) like lower(concat('%', :nomeAutor, '%'))")
    public List<Trabalho> buscarPorTituloENomeAutor(String titulo, String nomeAutor);
    
}
