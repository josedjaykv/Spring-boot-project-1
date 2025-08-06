package com.implementacion.springbootproject1.controllers;

import com.implementacion.springbootproject1.services.BullyService;
import com.implementacion.springbootproject1.services.RevengePlanService;
import com.implementacion.springbootproject1.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/line")
@CrossOrigin(origins = "*")
public class LineSpecialController {

    @Autowired
    private StatsService statsService;

    @Autowired
    private BullyService bullyService;

    @Autowired
    private RevengePlanService revengePlanService;

    // Dashboard principal de Line con todo el tea ☕
    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> getLineDashboard() {
        Map<String, Object> dashboard = new HashMap<>();

        dashboard.put("message", "Welcome back, Queen Line! Your revenge empire awaits 👑");
        dashboard.put("stats", statsService.getDashboardStats());
        dashboard.put("recentBullies", bullyService.getAllBullies().stream().limit(5).toList());
        dashboard.put("pendingPlans", revengePlanService.getPendingRevengePlans().stream().limit(3).toList());
        dashboard.put("motivationalQuote", "Forgive? Maybe. Forget? Jamás. Revenge? Absolutely—rendered at 60 fps with motion blur. 🎬");

        return ResponseEntity.ok(dashboard);
    }

    // Endpoint para cuando Line se siente victoriosa
    @PostMapping("/victory-dance")
    public ResponseEntity<Map<String, String>> victoryDance() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "ICONIC");
        response.put("message", "Line just served JUSTICE at 4K resolution! 💅✨");
        response.put("energy", "Main character energy is OFF THE CHARTS!");

        return ResponseEntity.ok(response);
    }

    // Búsqueda inteligente de bullies por nivel de toxicidad
    @GetMapping("/target-analysis")
    public ResponseEntity<Map<String, Object>> getTargetAnalysis(@RequestParam(defaultValue = "7") Integer minAnnoyanceLevel) {
        Map<String, Object> analysis = new HashMap<>();

        // Aquí Line puede filtrar sus targets más priority
        analysis.put("highPriorityTargets", "Kevin Martinez, Sofia Hernandez"); // Hardcodeado para el ejemplo
        analysis.put("strategy", "Focus on the 8+ annoyance level bullies first");
        analysis.put("recommendation", "Kevin needs the full TikTok treatment. Sofia requires Instagram story exposé.");
        analysis.put("confidenceLevel", "100% - Line's got the receipts 📸");

        return ResponseEntity.ok(analysis);
    }
}