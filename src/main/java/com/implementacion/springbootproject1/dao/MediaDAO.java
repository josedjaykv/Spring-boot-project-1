package com.implementacion.springbootproject1.dao;

import com.implementacion.springbootproject1.models.Media;
import java.util.List;
import java.util.Optional;

public interface MediaDAO {
    List<Media> findAll();
    Optional<Media> findById(Long id);
    Media save(Media media);
    void deleteById(Long id);
    List<Media> findByRevengePlanId(Long revengePlanId);
}