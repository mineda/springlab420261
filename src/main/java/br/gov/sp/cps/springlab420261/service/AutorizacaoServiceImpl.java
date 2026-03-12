package br.gov.sp.cps.springlab420261.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.cps.springlab420261.entity.Autorizacao;
import br.gov.sp.cps.springlab420261.repository.AutorizacaoRepository;

@Service
public class AutorizacaoServiceImpl implements AutorizacaoService {

    private AutorizacaoRepository autorizacaoRepo;

    public AutorizacaoServiceImpl(AutorizacaoRepository autorizacaoRepo) {
        this.autorizacaoRepo = autorizacaoRepo;
    }
    
    @Override
    public Autorizacao buscarPorId(Long id) {
        return autorizacaoRepo.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Autorização com esse id não encontrada!");
        });
    }

    @Override
    public List<Autorizacao> listar() {
        return autorizacaoRepo.findAll();  
    }
}
