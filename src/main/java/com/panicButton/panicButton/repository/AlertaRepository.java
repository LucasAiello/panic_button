package com.panicButton.panicButton.repository;
import org.springframework.data.repository.CrudRepository;
import com.panicButton.panicButton.domain.Alerta;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRepository extends CrudRepository<Alerta, Integer> {}