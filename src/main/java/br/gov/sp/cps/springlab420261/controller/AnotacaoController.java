package br.gov.sp.cps.springlab420261.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.cps.springlab420261.entity.Anotacao;
import br.gov.sp.cps.springlab420261.service.AnotacaoService;

@RestController
@CrossOrigin
@RequestMapping("/anotacao")
public class AnotacaoController {

    private AnotacaoService service;

    public AnotacaoController(AnotacaoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @JsonView(View.Anotacao.class)
    public Anotacao buscarPorId(@PathVariable("id") Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    @JsonView(View.Anotacao.class)
    public List<Anotacao> buscarTodos() {
        return service.buscarTodos();
    }
    
}
