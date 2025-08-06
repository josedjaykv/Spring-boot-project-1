package com.implementacion.springbootproject1.dao;

import com.implementacion.springbootproject1.models.RevengePlan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class RevengePlanDAOImpl implements RevengePlanDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RevengePlan> findAll() {
        TypedQuery<RevengePlan> query = entityManager.createQuery("FROM RevengePlan", RevengePlan.class);
        return query.getResultList();
    }

    @Override
    public Optional<RevengePlan> findById(Long id) {
        RevengePlan plan = entityManager.find(RevengePlan.class, id);
        return Optional.ofNullable(plan);
    }

    @Override
    public RevengePlan save(RevengePlan revengePlan) {
        if (revengePlan.getId() == null) {
            entityManager.persist(revengePlan);
            return revengePlan;
        } else {
            return entityManager.merge(revengePlan);
        }
    }

    @Override
    public void deleteById(Long id) {
        RevengePlan plan = entityManager.find(RevengePlan.class, id);
        if (plan != null) {
            entityManager.remove(plan);
        }
    }

    @Override
    public List<RevengePlan> findByBullyId(Long bullyId) {
        TypedQuery<RevengePlan> query = entityManager.createQuery(
                "FROM RevengePlan r WHERE r.bully.id = :bullyId", RevengePlan.class);
        query.setParameter("bullyId", bullyId);
        return query.getResultList();
    }

    @Override
    public List<RevengePlan> findByIsExecuted(Boolean isExecuted) {
        TypedQuery<RevengePlan> query = entityManager.createQuery(
                "FROM RevengePlan r WHERE r.isExecuted = :isExecuted", RevengePlan.class);
        query.setParameter("isExecuted", isExecuted);
        return query.getResultList();
    }
}