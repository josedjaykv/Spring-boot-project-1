package com.implementacion.springbootproject1.dao;

import com.implementacion.springbootproject1.models.Bully;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class BullyDAOImpl implements BullyDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Bully> findAll() {
        TypedQuery<Bully> query = entityManager.createQuery("FROM Bully", Bully.class);
        return query.getResultList();
    }

    @Override
    public Optional<Bully> findById(Long id) {
        Bully bully = entityManager.find(Bully.class, id);
        return Optional.ofNullable(bully);
    }

    @Override
    public Bully save(Bully bully) {
        if (bully.getId() == null) {
            entityManager.persist(bully);
            return bully;
        } else {
            return entityManager.merge(bully);
        }
    }

    @Override
    public void deleteById(Long id) {
        Bully bully = entityManager.find(Bully.class, id);
        if (bully != null) {
            entityManager.remove(bully);
        }
    }

    @Override
    public List<Bully> findByCliqueId(Long cliqueId) {
        TypedQuery<Bully> query = entityManager.createQuery(
                "FROM Bully b WHERE b.clique.id = :cliqueId", Bully.class);
        query.setParameter("cliqueId", cliqueId);
        return query.getResultList();
    }

    @Override
    public List<Bully> findByLevelOfAnnoyanceGreaterThan(Integer level) {
        TypedQuery<Bully> query = entityManager.createQuery(
                "FROM Bully b WHERE b.levelOfAnnoyance > :level", Bully.class);
        query.setParameter("level", level);
        return query.getResultList();
    }
}