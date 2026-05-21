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

import br.gov.sp.cps.springlab420261.entity.Referencia;
import br.gov.sp.cps.springlab420261.service.ReferenciaService;

@RestController
@CrossOrigin
@RequestMapping("/referencia")
public class ReferenciaController {

    private final ReferenciaService service;

    public ReferenciaController(ReferenciaService service) {
        this.service = service;
    }

    @GetMapping
    @JsonView(View.Referencia.class)
    public List<Referencia> buscarTodas() {
        return service.buscarTodas();
    }

    @GetMapping("/{id}")
    @JsonView(View.Referencia.class)
    public Referencia buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    @JsonView(View.Referencia.class)
    public List<Referencia> buscarPorTituloSecaoEDataAcesso(@RequestParam("secao") String tituloSecao, @RequestParam("dataAcesso") LocalDate dataAcesso) {
        return service.buscarPorTituloSecaoEDataAcesso(tituloSecao, dataAcesso);
    }

    @PostMapping
    @JsonView(View.Referencia.class)
    public ResponseEntity<Referencia> cadastrar(@RequestBody Referencia referencia) {
        Referencia r = service.cadastrar(referencia);
        return ResponseEntity.created(URI.create("/referencia/" + r.getId())).body(r);
    }
    
}
