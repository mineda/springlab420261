package br.gov.sp.cps.springlab420261.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.cps.springlab420261.entity.Anotacao;
import br.gov.sp.cps.springlab420261.repository.AnotacaoRepository;

@Service
public class AnotacaoServiceImpl implements AnotacaoService {

    private AnotacaoRepository repo;

    public AnotacaoServiceImpl(AnotacaoRepository repo) {
        this.repo = repo;
    }
    
    @Override
    public Anotacao buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anotação não encontrada com id: " + id)
        );
    }

}
