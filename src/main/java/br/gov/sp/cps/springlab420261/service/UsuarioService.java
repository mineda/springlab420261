package br.gov.sp.cps.springlab420261.service;

import java.util.List;

import br.gov.sp.cps.springlab420261.entity.Usuario;

public interface UsuarioService {

    public Usuario cadastrar(Usuario usuario);

    public List<Usuario> listar();

    public Usuario buscarPorId(Long id);
    
}
