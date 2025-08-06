package com.implementacion.springbootproject1.controllers;

import com.implementacion.springbootproject1.dto.CreateMediaDTO;
import com.implementacion.springbootproject1.dto.MediaDTO;
import com.implementacion.springbootproject1.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
@CrossOrigin(origins = "*")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @GetMapping
    public ResponseEntity<List<MediaDTO>> getAllMedia() {
        List<MediaDTO> media = mediaService.getAllMedia();
        return ResponseEntity.ok(media);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaDTO> getMediaById(@PathVariable Long id) {
        MediaDTO media = mediaService.getMediaById(id);
        return ResponseEntity.ok(media);
    }

    @PostMapping
    public ResponseEntity<MediaDTO> createMedia(@RequestBody CreateMediaDTO createMediaDTO) {
        MediaDTO createdMedia = mediaService.createMedia(createMediaDTO);
        return new ResponseEntity<>(createdMedia, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable Long id) {
        mediaService.deleteMedia(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/revenge-plan/{revengePlanId}")
    public ResponseEntity<List<MediaDTO>> getMediaByRevengePlan(@PathVariable Long revengePlanId) {
        List<MediaDTO> media = mediaService.getMediaByRevengePlan(revengePlanId);
        return ResponseEntity.ok(media);
    }

    // Endpoint especial para subir memes y fotos a un revenge plan específico
    @PostMapping("/revenge-plans/{revengePlanId}/upload")
    public ResponseEntity<MediaDTO> uploadMediaToRevengePlan(@PathVariable Long revengePlanId,
                                                             @RequestBody CreateMediaDTO createMediaDTO) {
        createMediaDTO.setRevengePlanId(revengePlanId);
        MediaDTO createdMedia = mediaService.createMedia(createMediaDTO);
        return new ResponseEntity<>(createdMedia, HttpStatus.CREATED);
    }
}