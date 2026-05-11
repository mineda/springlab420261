package br.gov.sp.cps.springlab420261.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.cps.springlab420261.entity.Autorizacao;
import br.gov.sp.cps.springlab420261.entity.Usuario;
import br.gov.sp.cps.springlab420261.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepo;

    private AutorizacaoService autorizacaoService;

    private PasswordEncoder encoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepo, AutorizacaoService autorizacaoService, PasswordEncoder encoder) {
        this.usuarioRepo = usuarioRepo;
        this.autorizacaoService = autorizacaoService;
        this.encoder = encoder;
    }

    @Override
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public Usuario cadastrar(Usuario usuario) {
        if(usuario == null || 
                usuario.getId() != null ||
                usuario.getNome() == null ||
                usuario.getNome().isBlank() ||
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário com informações inválidas!");
        }
        if(usuario.getAutorizacoes() != null) {
            Set<Autorizacao> autorizacoes = new HashSet<>();
            for(Autorizacao aut : usuario.getAutorizacoes()) {
                autorizacoes.add(autorizacaoService.buscarPorId(aut.getId()));
            }
            usuario.setAutorizacoes(autorizacoes);
        }
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return usuarioRepo.save(usuario);   
    }
    
    @Override
    public List<Usuario> listar() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepo.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário com esse id não encontrado!");
        });
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Usuario> buscarPorNomeAutorizacao(String nomeAutorizacao) {
        return usuarioRepo.findByAutorizacoesNome(nomeAutorizacao);
    }
    
}
