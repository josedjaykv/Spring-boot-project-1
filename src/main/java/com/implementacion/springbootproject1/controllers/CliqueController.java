package com.implementacion.springbootproject1.controllers;

import com.implementacion.springbootproject1.dto.CliqueDTO;
import com.implementacion.springbootproject1.services.CliqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliques")
@CrossOrigin(origins = "*")
public class CliqueController {

    @Autowired
    private CliqueService cliqueService;

    @GetMapping
    public ResponseEntity<List<CliqueDTO>> getAllCliques() {
        List<CliqueDTO> cliques = cliqueService.getAllCliques();
        return ResponseEntity.ok(cliques);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CliqueDTO> getCliqueById(@PathVariable Long id) {
        CliqueDTO clique = cliqueService.getCliqueById(id);
        return ResponseEntity.ok(clique);
    }

    @PostMapping
    public ResponseEntity<CliqueDTO> createClique(@RequestBody CliqueDTO cliqueDTO) {
        CliqueDTO createdClique = cliqueService.createClique(cliqueDTO);
        return new ResponseEntity<>(createdClique, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClique(@PathVariable Long id) {
        cliqueService.deleteClique(id);
        return ResponseEntity.noContent().build();
    }
}