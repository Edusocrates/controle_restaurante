package com.fiap.RM358568.edusocrates.controle_restaurante.API.controllers.usuario;

import com.fiap.RM358568.edusocrates.controle_restaurante.API.requests.UsuarioRequest;
import com.fiap.RM358568.edusocrates.controle_restaurante.API.responses.UsuarioResponse;
import com.fiap.RM358568.edusocrates.controle_restaurante.aplicacao.usecases.UsuarioUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários", description = "Operações relacionadas aos usuários do sistema")
public class UsuarioController {

    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @GetMapping("/{id}")
    @Tag(name = "Buscar usuário por ID", description = "Buscar um usuário por ID")
    @Operation(summary = "Buscar usuário por ID", description = "Buscar um usuário por ID")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioUseCase.buscarPorId(id));
    }

    @PostMapping
    @Tag(name = "Salvar usuário", description = "Salvar um novo usuário")
    @Operation(summary = "Salvar usuário", description = "Salvar um novo usuário")
    public ResponseEntity<UsuarioResponse> salvar(@Validated @RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.ok(usuarioUseCase.salvar(usuarioRequest));
    }
}
