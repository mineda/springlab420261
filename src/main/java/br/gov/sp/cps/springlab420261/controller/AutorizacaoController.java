package br.gov.sp.cps.springlab420261.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.cps.springlab420261.entity.Autorizacao;
import br.gov.sp.cps.springlab420261.service.AutorizacaoService;

@RestController
@CrossOrigin
@RequestMapping("/autorizacao")
public class AutorizacaoController {

    private AutorizacaoService service;

    public AutorizacaoController(AutorizacaoService service) {
        this.service = service;
    }

    @GetMapping
    @JsonView(View.Autorizacao.class)
    public ResponseEntity<List<Autorizacao>> listar() {
        return ResponseEntity.ok(service.listar());
    }
    
}
