package com.implementacion.springbootproject1.services;

import com.implementacion.springbootproject1.dto.MoodTrackerDTO;
import java.time.LocalDate;
import java.util.List;

public interface MoodTrackerService {
    List<MoodTrackerDTO> getAllMoodEntries();
    MoodTrackerDTO getMoodEntryById(Long id);
    MoodTrackerDTO createMoodEntry(MoodTrackerDTO moodTrackerDTO);
    MoodTrackerDTO updateMoodEntry(Long id, MoodTrackerDTO moodTrackerDTO);
    void deleteMoodEntry(Long id);
    List<MoodTrackerDTO> getMoodEntriesByDateRange(LocalDate startDate, LocalDate endDate);
    Double getAverageMoodLevel();
}