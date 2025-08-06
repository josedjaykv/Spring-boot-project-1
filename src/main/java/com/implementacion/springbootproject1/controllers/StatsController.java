package com.implementacion.springbootproject1.controllers;

import com.implementacion.springbootproject1.dto.StatsDTO;
import com.implementacion.springbootproject1.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin(origins = "*")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/dashboard")
    public ResponseEntity<StatsDTO> getDashboardStats() {
        StatsDTO stats = statsService.getDashboardStats();
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/revenge-summary")
    public ResponseEntity<String> getRevengeSummary() {
        // Endpoint especial para el dashboard de Line
        return ResponseEntity.ok("Line's Revenge Empire: Operational and Thriving at 60fps! 🔥");
    }
}