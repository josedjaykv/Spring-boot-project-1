package com.implementacion.springbootproject1.controllers;

import com.implementacion.springbootproject1.dto.MoodTrackerDTO;
import com.implementacion.springbootproject1.services.MoodTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/mood-tracker")
@CrossOrigin(origins = "*")
public class MoodTrackerController {

    @Autowired
    private MoodTrackerService moodTrackerService;

    @GetMapping
    public ResponseEntity<List<MoodTrackerDTO>> getAllMoodEntries() {
        List<MoodTrackerDTO> moodEntries = moodTrackerService.getAllMoodEntries();
        return ResponseEntity.ok(moodEntries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MoodTrackerDTO> getMoodEntryById(@PathVariable Long id) {
        MoodTrackerDTO moodEntry = moodTrackerService.getMoodEntryById(id);
        return ResponseEntity.ok(moodEntry);
    }

    @PostMapping
    public ResponseEntity<MoodTrackerDTO> createMoodEntry(@RequestBody MoodTrackerDTO moodTrackerDTO) {
        MoodTrackerDTO createdEntry = moodTrackerService.createMoodEntry(moodTrackerDTO);
        return new ResponseEntity<>(createdEntry, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MoodTrackerDTO> updateMoodEntry(@PathVariable Long id,
                                                          @RequestBody MoodTrackerDTO moodTrackerDTO) {
        MoodTrackerDTO updatedEntry = moodTrackerService.updateMoodEntry(id, moodTrackerDTO);
        return ResponseEntity.ok(updatedEntry);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMoodEntry(@PathVariable Long id) {
        moodTrackerService.deleteMoodEntry(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/range")
    public ResponseEntity<List<MoodTrackerDTO>> getMoodEntriesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<MoodTrackerDTO> entries = moodTrackerService.getMoodEntriesByDateRange(startDate, endDate);
        return ResponseEntity.ok(entries);
    }

    @GetMapping("/average")
    public ResponseEntity<Double> getAverageMoodLevel() {
        Double average = moodTrackerService.getAverageMoodLevel();
        return ResponseEntity.ok(average);
    }
}