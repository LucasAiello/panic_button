package com.panicButton.panicButton.repository;

import com.panicButton.panicButton.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
}