package com.panicButton.panicButton.repository;
import org.springframework.data.repository.CrudRepository;
import com.panicButton.panicButton.domain.Alerta;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertaRepository extends CrudRepository<Alerta, Long> {
    List<Alerta> findByUsuarioId(Long usuarioId);
}