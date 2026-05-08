package br.gov.sp.cps.springlab420261.service;

import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.gov.sp.cps.springlab420261.entity.Autorizacao;
import br.gov.sp.cps.springlab420261.entity.Usuario;
import br.gov.sp.cps.springlab420261.repository.UsuarioRepository;

@Service
public class SegurancaServiceImpl implements UserDetailsService{

    private UsuarioRepository repo;

    public SegurancaServiceImpl(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repo.findByNome(username).orElseThrow(
            () -> new UsernameNotFoundException("Usuário não encontrado: " + username)
        );
        return User.builder().username(username).password(usuario.getSenha())
                    .authorities(usuario.getAutorizacoes().stream()
                        .map(Autorizacao::getNome).collect(Collectors.toList())
                        .toArray(new String[usuario.getAutorizacoes().size()])).build();
    }
    
}
