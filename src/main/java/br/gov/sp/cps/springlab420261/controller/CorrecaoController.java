package br.gov.sp.cps.springlab420261.controller;

import java.net.URI;
import java.time.LocalDateTime;
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

import br.gov.sp.cps.springlab420261.entity.Correcao;
import br.gov.sp.cps.springlab420261.service.CorrecaoService;

@RestController
@CrossOrigin
@RequestMapping("/correcao")
public class CorrecaoController {

    private CorrecaoService service;

    public CorrecaoController(CorrecaoService service) {
        this.service = service;
    }

    @GetMapping("/buscar")
    @JsonView(View.Correcao.class)
    public List<Correcao> buscarCorrecaoPorAnotacaoEDataHora(@RequestParam("anotacao") String textoAnotacao, @RequestParam("dataHora") LocalDateTime dataHora) {
        return service.buscarCorrecaoPorAnotacaoEDataHora(textoAnotacao, dataHora);
    }

    @GetMapping
    @JsonView(View.Correcao.class)
    public List<Correcao> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    @JsonView(View.Correcao.class)
    public Correcao buscarCorrecaoPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @JsonView(View.Correcao.class)
    public ResponseEntity<Correcao> cadastrar(@RequestBody Correcao correcao) {
        Correcao criado = service.cadastrar(correcao);
        return ResponseEntity.created(URI.create("/correcao/" + criado.getId())).body(criado);
    }

}
