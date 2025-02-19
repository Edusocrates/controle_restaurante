package com.fiap.RM358568.edusocrates.controle_restaurante.dominio.gateways;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;

public interface UsuarioGateway {

    Usuario save(Usuario usuario);

    Usuario findById(Long id);

    Usuario findByEmail(String email);
}
