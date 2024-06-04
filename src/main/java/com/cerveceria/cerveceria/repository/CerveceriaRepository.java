package com.cerveceria.cerveceria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cerveceria.cerveceria.domain.Cerveceria;

public interface CerveceriaRepository extends JpaRepository<Cerveceria, Long>{
    List<Cerveceria> findByNombreContaining(String nombre);
}
