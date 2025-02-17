package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.usuario;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.requests.UsuarioRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.responses.UsuarioResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.UsuarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioUseCase.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> salvar(@Validated @RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.ok(usuarioUseCase.salvar(usuarioRequest));
    }
}
