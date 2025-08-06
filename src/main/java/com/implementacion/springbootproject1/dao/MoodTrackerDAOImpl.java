package com.implementacion.springbootproject1.dao;

import com.implementacion.springbootproject1.models.MoodTracker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MoodTrackerDAOImpl implements MoodTrackerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MoodTracker> findAll() {
        TypedQuery<MoodTracker> query = entityManager.createQuery("FROM MoodTracker ORDER BY date DESC", MoodTracker.class);
        return query.getResultList();
    }

    @Override
    public Optional<MoodTracker> findById(Long id) {
        MoodTracker mood = entityManager.find(MoodTracker.class, id);
        return Optional.ofNullable(mood);
    }

    @Override
    public MoodTracker save(MoodTracker moodTracker) {
        if (moodTracker.getId() == null) {
            entityManager.persist(moodTracker);
            return moodTracker;
        } else {
            return entityManager.merge(moodTracker);
        }
    }

    @Override
    public void deleteById(Long id) {
        MoodTracker mood = entityManager.find(MoodTracker.class, id);
        if (mood != null) {
            entityManager.remove(mood);
        }
    }

    @Override
    public List<MoodTracker> findByDateBetween(LocalDate startDate, LocalDate endDate) {
        TypedQuery<MoodTracker> query = entityManager.createQuery(
                "FROM MoodTracker m WHERE m.date BETWEEN :startDate AND :endDate ORDER BY m.date DESC",
                MoodTracker.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    @Override
    public Optional<MoodTracker> findByDate(LocalDate date) {
        TypedQuery<MoodTracker> query = entityManager.createQuery(
                "FROM MoodTracker m WHERE m.date = :date", MoodTracker.class);
        query.setParameter("date", date);
        List<MoodTracker> results = query.getResultList();
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }
}