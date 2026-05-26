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

import br.gov.sp.cps.springlab420261.entity.Revisao;
import br.gov.sp.cps.springlab420261.service.RevisaoService;

@RestController
@CrossOrigin
@RequestMapping("/revisao")
public class RevisaoController {

    private RevisaoService service;

    public RevisaoController(RevisaoService service) {
        this.service = service;
    }

    @GetMapping
    @JsonView(View.Revisao.class)
    public List<Revisao> buscarTodas() {
        return service.buscarTodas();
    }

    @GetMapping("/busca")
    @JsonView(View.Revisao.class)
    public List<Revisao> buscarPorTrabalhoEData(@RequestParam("trabalho") String tituloTrabalho, @RequestParam("data") LocalDate dataRevisao) {
        return service.buscarPorTrabalhoEData(tituloTrabalho, dataRevisao);
    }

    @GetMapping("/{id}")
    @JsonView(View.Revisao.class)
    public Revisao buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @JsonView(View.Revisao.class)
    public ResponseEntity<Revisao> cadastrar(@RequestBody Revisao revisao) {
        Revisao novaRevisao = service.cadastrar(revisao);
        return ResponseEntity.created(URI.create("/revisao/" + novaRevisao.getId())).body(novaRevisao);
    }
}
