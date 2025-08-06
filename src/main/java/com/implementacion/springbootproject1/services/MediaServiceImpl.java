package com.implementacion.springbootproject1.services;

import com.implementacion.springbootproject1.dao.MediaDAO;
import com.implementacion.springbootproject1.dao.RevengePlanDAO;
import com.implementacion.springbootproject1.dto.CreateMediaDTO;
import com.implementacion.springbootproject1.dto.MediaDTO;
import com.implementacion.springbootproject1.excepciones.RevengePlanNotFoundException;
import com.implementacion.springbootproject1.models.Media;
import com.implementacion.springbootproject1.models.RevengePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private MediaDAO mediaDAO;

    @Autowired
    private RevengePlanDAO revengePlanDAO;

    @Override
    public List<MediaDTO> getAllMedia() {
        return mediaDAO.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MediaDTO getMediaById(Long id) {
        Media media = mediaDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Media not found with id: " + id));
        return convertToDTO(media);
    }

    @Override
    public MediaDTO createMedia(CreateMediaDTO createMediaDTO) {
        RevengePlan revengePlan = revengePlanDAO.findById(createMediaDTO.getRevengePlanId())
                .orElseThrow(() -> new RevengePlanNotFoundException("Revenge plan not found with id: " + createMediaDTO.getRevengePlanId()));

        Media media = new Media();
        media.setRevengePlan(revengePlan);
        media.setType(createMediaDTO.getType());
        media.setUrl(createMediaDTO.getUrl());
        media.setCaption(createMediaDTO.getCaption());

        Media savedMedia = mediaDAO.save(media);
        return convertToDTO(savedMedia);
    }

    @Override
    public void deleteMedia(Long id) {
        if (!mediaDAO.findById(id).isPresent()) {
            throw new RuntimeException("Media not found with id: " + id);
        }
        mediaDAO.deleteById(id);
    }

    @Override
    public List<MediaDTO> getMediaByRevengePlan(Long revengePlanId) {
        return mediaDAO.findByRevengePlanId(revengePlanId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private MediaDTO convertToDTO(Media media) {
        MediaDTO dto = new MediaDTO();
        dto.setId(media.getId());
        dto.setRevengePlanId(media.getRevengePlan().getId());
        dto.setRevengePlanTitle(media.getRevengePlan().getTitle());
        dto.setType(media.getType());
        dto.setUrl(media.getUrl());
        dto.setCaption(media.getCaption());
        return dto;
    }
}