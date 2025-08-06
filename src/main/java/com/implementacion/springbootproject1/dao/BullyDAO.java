package com.implementacion.springbootproject1.dao;

import com.implementacion.springbootproject1.models.Bully;
import java.util.List;
import java.util.Optional;

public interface BullyDAO {
    List<Bully> findAll();
    Optional<Bully> findById(Long id);
    Bully save(Bully bully);
    void deleteById(Long id);
    List<Bully> findByCliqueId(Long cliqueId);
    List<Bully> findByLevelOfAnnoyanceGreaterThan(Integer level);
}