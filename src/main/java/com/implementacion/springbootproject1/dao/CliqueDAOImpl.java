package com.implementacion.springbootproject1.dao;

import com.implementacion.springbootproject1.models.Clique;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CliqueDAOImpl implements CliqueDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Clique> findAll() {
        TypedQuery<Clique> query = entityManager.createQuery("FROM Clique", Clique.class);
        return query.getResultList();
    }

    @Override
    public Optional<Clique> findById(Long id) {
        Clique clique = entityManager.find(Clique.class, id);
        return Optional.ofNullable(clique);
    }

    @Override
    public Clique save(Clique clique) {
        if (clique.getId() == null) {
            entityManager.persist(clique);
            return clique;
        } else {
            return entityManager.merge(clique);
        }
    }

    @Override
    public void deleteById(Long id) {
        Clique clique = entityManager.find(Clique.class, id);
        if (clique != null) {
            entityManager.remove(clique);
        }
    }
}