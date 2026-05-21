package br.gov.sp.cps.springlab420261.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.cps.springlab420261.entity.Secao;
import br.gov.sp.cps.springlab420261.repository.SecaoRepository;

@Service
public class SecaoServiceImpl implements SecaoService {

    private final SecaoRepository repo;

    private final CapituloService capituloService;

    public SecaoServiceImpl(SecaoRepository repo, CapituloService capituloService) {
        this.repo = repo;
        this.capituloService = capituloService;
    }

    @Override
    public Secao cadastrar(Secao secao) {
        if(secao == null || 
                secao.getTitulo() == null || 
                secao.getTitulo().isBlank() ||
                secao.getCapitulo() == null ||
                secao.getCapitulo().getId() == null ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos obrigatórios não informados.");
        }
        if(secao.getDataCriacao() == null) {
            secao.setDataCriacao(LocalDate.now());
        }
        secao.setCapitulo(capituloService.buscarPorId(secao.getCapitulo().getId()));
        return repo.save(secao);
    }

    @Override
    public List<Secao> buscarTodas() {
        return repo.findAll();
    }

    @Override
    public Secao buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Seção não encontra com id " + id)
        );
    }

    @Override
    public List<Secao> buscarPorTituloCapituloEDataAprovacao(String titulo, LocalDate dataAprovacao) {
        if(titulo == null || titulo.isBlank() ||
                dataAprovacao == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parâmetros de busca inválidos: titulo e dataAprovacao são obrigatórios e devem ser válidos.");
        }
        return repo.findByCapituloTituloContainingIgnoreCaseAndDataAprovacaoGreaterThan(titulo, dataAprovacao);
    }
}
