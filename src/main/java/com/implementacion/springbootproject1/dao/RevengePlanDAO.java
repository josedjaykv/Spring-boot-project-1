package com.implementacion.springbootproject1.dao;

import com.implementacion.springbootproject1.models.RevengePlan;
import java.util.List;
import java.util.Optional;

public interface RevengePlanDAO {
    List<RevengePlan> findAll();
    Optional<RevengePlan> findById(Long id);
    RevengePlan save(RevengePlan revengePlan);
    void deleteById(Long id);
    List<RevengePlan> findByBullyId(Long bullyId);
    List<RevengePlan> findByIsExecuted(Boolean isExecuted);
}