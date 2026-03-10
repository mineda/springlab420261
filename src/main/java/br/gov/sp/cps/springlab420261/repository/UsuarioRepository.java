package br.gov.sp.cps.springlab420261.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.cps.springlab420261.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    @Query("SELECT u FROM Usuario u WHERE u.nome = :nome")
    public Optional<Usuario> buscarPorNome(String nome);
    
    public Optional<Usuario> findByNome(String nome);

    @Query("SELECT u FROM Usuario u WHERE LOWER(u.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    public List<Usuario> buscarPorNomeQueContenha(String nome);

    public List<Usuario> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT u FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha")
    public Optional<Usuario> buscarPorNomeESenha(String nome, String senha);
    
    public Optional<Usuario> findByNomeAndSenha(String nome, String senha);

    @Query("SELECT u FROM Usuario u JOIN u.autorizacoes a WHERE a.nome = :nomeAutorizacao")
    public List<Usuario> buscarPorNomeDeAutorizacao(String nomeAutorizacao);

    public List<Usuario> findByAutorizacoesNome(String nomeAutorizacao);
    
}
