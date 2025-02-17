package com.fiap.RM358568.edusocrates.controle_restaurante.infraestrutura.repositorios;

import com.fiap.RM358568.edusocrates.controle_restaurante.dominio.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
