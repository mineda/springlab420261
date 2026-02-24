package br.gov.sp.cps.springlab420261.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.cps.springlab420261.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
