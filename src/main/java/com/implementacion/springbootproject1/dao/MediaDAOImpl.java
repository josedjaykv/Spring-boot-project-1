package com.implementacion.springbootproject1.dao;

import com.implementacion.springbootproject1.models.Media;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MediaDAOImpl implements MediaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Media> findAll() {
        TypedQuery<Media> query = entityManager.createQuery("FROM Media", Media.class);
        return query.getResultList();
    }

    @Override
    public Optional<Media> findById(Long id) {
        Media media = entityManager.find(Media.class, id);
        return Optional.ofNullable(media);
    }

    @Override
    public Media save(Media media) {
        if (media.getId() == null) {
            entityManager.persist(media);
            return media;
        } else {
            return entityManager.merge(media);
        }
    }

    @Override
    public void deleteById(Long id) {
        Media media = entityManager.find(Media.class, id);
        if (media != null) {
            entityManager.remove(media);
        }
    }

    @Override
    public List<Media> findByRevengePlanId(Long revengePlanId) {
        TypedQuery<Media> query = entityManager.createQuery(
                "FROM Media m WHERE m.revengePlan.id = :revengePlanId", Media.class);
        query.setParameter("revengePlanId", revengePlanId);
        return query.getResultList();
    }
}