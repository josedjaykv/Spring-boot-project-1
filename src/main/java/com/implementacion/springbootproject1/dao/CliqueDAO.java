package com.implementacion.springbootproject1.dao;

import com.implementacion.springbootproject1.models.Clique;
import java.util.List;
import java.util.Optional;

public interface CliqueDAO {
    List<Clique> findAll();
    Optional<Clique> findById(Long id);
    Clique save(Clique clique);
    void deleteById(Long id);
}