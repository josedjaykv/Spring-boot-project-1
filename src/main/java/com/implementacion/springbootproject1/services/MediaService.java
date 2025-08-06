package com.implementacion.springbootproject1.services;

import com.implementacion.springbootproject1.dto.CreateMediaDTO;
import com.implementacion.springbootproject1.dto.MediaDTO;
import java.util.List;

public interface MediaService {
    List<MediaDTO> getAllMedia();
    MediaDTO getMediaById(Long id);
    MediaDTO createMedia(CreateMediaDTO createMediaDTO);
    void deleteMedia(Long id);
    List<MediaDTO> getMediaByRevengePlan(Long revengePlanId);
}