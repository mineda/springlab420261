package br.gov.sp.cps.springlab420261.controller;

import java.net.URI;
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

import br.gov.sp.cps.springlab420261.entity.Usuario;
import br.gov.sp.cps.springlab420261.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    @JsonView(View.UsuarioResumo.class)
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    @JsonView(View.UsuarioCompleto.class)
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
        usuario = service.cadastrar(usuario);
        return ResponseEntity.created(URI.create("/usuario/" + usuario.getId())).body(usuario);
    }

    @GetMapping("/{id}")
    @JsonView(View.UsuarioCompleto.class)
    public ResponseEntity<Usuario> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/buscarid")
    @JsonView(View.UsuarioCompleto.class)
    public ResponseEntity<Usuario> buscarPorIdParam(@RequestParam("id") Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
    
}
