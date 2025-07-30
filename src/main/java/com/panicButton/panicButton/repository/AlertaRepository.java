package com.panicButton.panicButton.repository;
import org.springframework.data.repository.CrudRepository;
import com.panicButton.panicButton.domain.Alerta;
import org.springframework.stereotype.Repository;
import com.panicButton.panicButton.domain.Usuario;

import java.util.List;

@Repository
public interface AlertaRepository extends CrudRepository<Alerta, Long> {
    List<Alerta> findByUsuario(Usuario usuario);
}