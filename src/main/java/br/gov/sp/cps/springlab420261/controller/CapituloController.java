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

import br.gov.sp.cps.springlab420261.entity.Capitulo;
import br.gov.sp.cps.springlab420261.service.CapituloService;

@RestController
@CrossOrigin
@RequestMapping("/capitulo")
public class CapituloController {

    private final CapituloService service;

    public CapituloController(CapituloService service) {
        this.service = service;
    }

    @GetMapping
    @JsonView(View.Capitulo.class)
    public List<Capitulo> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    @JsonView(View.Capitulo.class)
    public Capitulo buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    @JsonView(View.Capitulo.class)
    public List<Capitulo> buscarCapitulosAtrasados(@RequestParam("trabalho") String tituloTrabalho, @RequestParam("dataCriacao") LocalDate dataCriacao) {
        return service.buscarCapitulosAtrasados(tituloTrabalho, dataCriacao);
    }

    @PostMapping
    @JsonView(View.Capitulo.class)
    public ResponseEntity<Capitulo> cadastrar(@RequestBody Capitulo capitulo) {
        Capitulo c = service.cadastrar(capitulo);
        return ResponseEntity.created(URI.create("/capitulo/" + c.getId())).body(c);
    }

}
