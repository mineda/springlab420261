package br.gov.sp.cps.springlab420261.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.cps.springlab420261.entity.Trabalho;
import br.gov.sp.cps.springlab420261.service.TrabalhoService;

@RestController
@CrossOrigin
@RequestMapping("/trabalho")
public class TrabalhoController {

    private TrabalhoService service;

    public TrabalhoController(TrabalhoService service) {
        this.service = service;
    }

    @GetMapping
    @JsonView(View.Trabalho.class)
    public ResponseEntity<List<Trabalho>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    @JsonView(View.Trabalho.class)
    public ResponseEntity<Trabalho> cadastrar(@RequestBody Trabalho trabalho) {
        Trabalho trabalhoCadastrado = service.cadastrar(trabalho);
        return ResponseEntity.created(URI.create("/trabalho/" + trabalhoCadastrado.getId())).body(trabalhoCadastrado);
    }

    @GetMapping("/buscar")
    @JsonView(View.Trabalho.class)
    public ResponseEntity<List<Trabalho>> buscarPorTituloENomeAutor(@RequestParam("titulo") String titulo, @RequestParam("autor") String nomeAutor) {
        return ResponseEntity.ok(service.buscarPorTituloENomeAutor(titulo, nomeAutor));
    }
    
}
