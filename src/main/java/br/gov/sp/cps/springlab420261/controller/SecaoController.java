package br.gov.sp.cps.springlab420261.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.cps.springlab420261.entity.Secao;
import br.gov.sp.cps.springlab420261.service.SecaoService;

@RestController
@CrossOrigin
@RequestMapping("/secao")
public class SecaoController {

    private final SecaoService service;

    public SecaoController(SecaoService service) {
        this.service = service;
    }

    @GetMapping
    @JsonView(View.Secao.class)
    public List<Secao> buscarTodas() {
        return service.buscarTodas();
    }

    @GetMapping("/{id}")
    @JsonView(View.Secao.class)
    public Secao buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    @JsonView(View.Secao.class)
    public List<Secao> buscarPorTituloCapituloEDataAprovacao(@RequestParam("capitulo") String tituloCapitulo, @RequestParam("dataAprovacao") LocalDate dataAprovacao) {
        return service.buscarPorTituloCapituloEDataAprovacao(tituloCapitulo, dataAprovacao);
    }

    @PostMapping
    @JsonView(View.Secao.class)
    public ResponseEntity<Secao> cadastrar(@RequestBody Secao secao) {
        Secao s = service.cadastrar(secao);
        return ResponseEntity.created(URI.create("/secao/" + s.getId())).body(s);
    }
    
}
