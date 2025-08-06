package com.implementacion.springbootproject1.controllers;

import com.implementacion.springbootproject1.dto.BullyDTO;
import com.implementacion.springbootproject1.dto.CreateBullyDTO;
import com.implementacion.springbootproject1.services.BullyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bullies")
@CrossOrigin(origins = "*")
public class BullyController {

    @Autowired
    private BullyService bullyService;

    @GetMapping
    public ResponseEntity<List<BullyDTO>> getAllBullies() {
        List<BullyDTO> bullies = bullyService.getAllBullies();
        return ResponseEntity.ok(bullies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BullyDTO> getBullyById(@PathVariable Long id) {
        BullyDTO bully = bullyService.getBullyById(id);
        return ResponseEntity.ok(bully);
    }

    @PostMapping
    public ResponseEntity<BullyDTO> createBully(@RequestBody CreateBullyDTO createBullyDTO) {
        BullyDTO createdBully = bullyService.createBully(createBullyDTO);
        return new ResponseEntity<>(createdBully, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BullyDTO> updateBully(@PathVariable Long id,
                                                @RequestBody CreateBullyDTO updateBullyDTO) {
        BullyDTO updatedBully = bullyService.updateBully(id, updateBullyDTO);
        return ResponseEntity.ok(updatedBully);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBully(@PathVariable Long id) {
        bullyService.deleteBully(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/clique/{cliqueId}")
    public ResponseEntity<List<BullyDTO>> getBulliesByClique(@PathVariable Long cliqueId) {
        List<BullyDTO> bullies = bullyService.getBulliesByClique(cliqueId);
        return ResponseEntity.ok(bullies);
    }
}