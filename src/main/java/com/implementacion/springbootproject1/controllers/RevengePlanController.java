package com.implementacion.springbootproject1.controllers;

import com.implementacion.springbootproject1.dto.CreateRevengePlanDTO;
import com.implementacion.springbootproject1.dto.RevengePlanDTO;
import com.implementacion.springbootproject1.models.enums.SuccessLevel;
import com.implementacion.springbootproject1.services.RevengePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/revenge-plans")
@CrossOrigin(origins = "*")
public class RevengePlanController {

    @Autowired
    private RevengePlanService revengePlanService;

    @GetMapping
    public ResponseEntity<List<RevengePlanDTO>> getAllRevengePlans() {
        List<RevengePlanDTO> plans = revengePlanService.getAllRevengePlans();
        return ResponseEntity.ok(plans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevengePlanDTO> getRevengePlanById(@PathVariable Long id) {
        RevengePlanDTO plan = revengePlanService.getRevengePlanById(id);
        return ResponseEntity.ok(plan);
    }

    @PostMapping
    public ResponseEntity<RevengePlanDTO> createRevengePlan(@RequestBody CreateRevengePlanDTO createRevengePlanDTO) {
        RevengePlanDTO createdPlan = revengePlanService.createRevengePlan(createRevengePlanDTO);
        return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/execute")
    public ResponseEntity<RevengePlanDTO> executeRevengePlan(@PathVariable Long id,
                                                             @RequestParam SuccessLevel successLevel) {
        RevengePlanDTO executedPlan = revengePlanService.executeRevengePlan(id, successLevel);
        return ResponseEntity.ok(executedPlan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRevengePlan(@PathVariable Long id) {
        revengePlanService.deleteRevengePlan(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/bully/{bullyId}")
    public ResponseEntity<List<RevengePlanDTO>> getRevengePlansByBully(@PathVariable Long bullyId) {
        List<RevengePlanDTO> plans = revengePlanService.getRevengePlansByBully(bullyId);
        return ResponseEntity.ok(plans);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<RevengePlanDTO>> getPendingRevengePlans() {
        List<RevengePlanDTO> plans = revengePlanService.getPendingRevengePlans();
        return ResponseEntity.ok(plans);
    }

    @GetMapping("/executed")
    public ResponseEntity<List<RevengePlanDTO>> getExecutedRevengePlans() {
        List<RevengePlanDTO> plans = revengePlanService.getExecutedRevengePlans();
        return ResponseEntity.ok(plans);
    }
}