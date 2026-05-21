package br.gov.sp.cps.springlab420261.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.cps.springlab420261.entity.Referencia;
import br.gov.sp.cps.springlab420261.repository.ReferenciaRepository;

@Service
public class ReferenciaServiceImpl implements ReferenciaService {

    private final ReferenciaRepository repo;

    private final SecaoService secaoService;

    public ReferenciaServiceImpl(ReferenciaRepository repo, SecaoService secaoService) {
        this.repo = repo;
        this.secaoService = secaoService;
    }

    @Override
    public Referencia cadastrar(Referencia referencia) {
        if(referencia == null || 
                referencia.getLink() == null || 
                referencia.getLink().isBlank() ||
                referencia.getDescricao() == null || 
                referencia.getDescricao().isBlank() ||
                referencia.getSecao() == null ||
                referencia.getSecao().getId() == null ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campos obrigatórios não informados.");
        }
        if(referencia.getAno() != null && referencia.getAno() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ano deve ser um valor positivo.");
        }
        if(referencia.getDataAcesso() == null) {
            referencia.setDataAcesso(LocalDate.now());
        }
        referencia.setSecao(secaoService.buscarPorId(referencia.getSecao().getId()));
        return repo.save(referencia);
    }

    @Override
    public List<Referencia> buscarTodas() {
        return repo.findAll();
    }

    @Override
    public Referencia buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Referência não encontrada com id " + id)
        );
    }

    @Override
    public List<Referencia> buscarPorTituloSecaoEDataAcesso(String titulo, LocalDate dataAcesso) {
        if(titulo == null || titulo.isBlank() ||
                dataAcesso == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parâmetros de busca inválidos: titulo e dataAcesso são obrigatórios e devem ser válidos.");
        }
        return repo.findBySecaoTituloContainingIgnoreCaseAndDataAcessoLessThan(titulo, dataAcesso);
    }
    
}
