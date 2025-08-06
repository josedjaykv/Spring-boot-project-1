package com.implementacion.springbootproject1.dao;

import com.implementacion.springbootproject1.models.MoodTracker;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MoodTrackerDAO {
    List<MoodTracker> findAll();
    Optional<MoodTracker> findById(Long id);
    MoodTracker save(MoodTracker moodTracker);
    void deleteById(Long id);
    List<MoodTracker> findByDateBetween(LocalDate startDate, LocalDate endDate);
    Optional<MoodTracker> findByDate(LocalDate date);
}