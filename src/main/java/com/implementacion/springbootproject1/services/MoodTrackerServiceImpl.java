package com.implementacion.springbootproject1.services;

import com.implementacion.springbootproject1.dao.MoodTrackerDAO;
import com.implementacion.springbootproject1.dto.MoodTrackerDTO;
import com.implementacion.springbootproject1.models.MoodTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoodTrackerServiceImpl implements MoodTrackerService {

    @Autowired
    private MoodTrackerDAO moodTrackerDAO;

    @Override
    public List<MoodTrackerDTO> getAllMoodEntries() {
        return moodTrackerDAO.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MoodTrackerDTO getMoodEntryById(Long id) {
        MoodTracker mood = moodTrackerDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Mood entry not found with id: " + id));
        return convertToDTO(mood);
    }

    @Override
    public MoodTrackerDTO createMoodEntry(MoodTrackerDTO moodTrackerDTO) {
        MoodTracker mood = new MoodTracker();
        mood.setDate(moodTrackerDTO.getDate());
        mood.setMoodLevel(moodTrackerDTO.getMoodLevel());
        mood.setNote(moodTrackerDTO.getNote());

        MoodTracker savedMood = moodTrackerDAO.save(mood);
        return convertToDTO(savedMood);
    }

    @Override
    public MoodTrackerDTO updateMoodEntry(Long id, MoodTrackerDTO moodTrackerDTO) {
        MoodTracker mood = moodTrackerDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Mood entry not found with id: " + id));

        mood.setDate(moodTrackerDTO.getDate());
        mood.setMoodLevel(moodTrackerDTO.getMoodLevel());
        mood.setNote(moodTrackerDTO.getNote());

        MoodTracker updatedMood = moodTrackerDAO.save(mood);
        return convertToDTO(updatedMood);
    }

    @Override
    public void deleteMoodEntry(Long id) {
        moodTrackerDAO.deleteById(id);
    }

    @Override
    public List<MoodTrackerDTO> getMoodEntriesByDateRange(LocalDate startDate, LocalDate endDate) {
        return moodTrackerDAO.findByDateBetween(startDate, endDate).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Double getAverageMoodLevel() {
        List<MoodTracker> allEntries = moodTrackerDAO.findAll();
        if (allEntries.isEmpty()) {
            return 0.0;
        }

        double sum = allEntries.stream()
                .mapToInt(MoodTracker::getMoodLevel)
                .sum();

        return sum / allEntries.size();
    }

    private MoodTrackerDTO convertToDTO(MoodTracker mood) {
        MoodTrackerDTO dto = new MoodTrackerDTO();
        dto.setId(mood.getId());
        dto.setDate(mood.getDate());
        dto.setMoodLevel(mood.getMoodLevel());
        dto.setNote(mood.getNote());
        return dto;
    }
}