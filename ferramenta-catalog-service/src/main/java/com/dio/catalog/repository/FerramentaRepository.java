package com.dio.catalog.repository;

import com.dio.catalog.model.Ferramenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FerramentaRepository extends JpaRepository<Ferramenta, Long> {
    // Aqui você pode definir consultas personalizadas se necessário
}
