package com.panicButton.panicButton.repository;

import com.panicButton.panicButton.domain.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, Integer> {
}
