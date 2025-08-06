package com.implementacion.springbootproject1.services;

import com.implementacion.springbootproject1.dto.BullyDTO;
import com.implementacion.springbootproject1.dto.CreateBullyDTO;
import java.util.List;

public interface BullyService {
    List<BullyDTO> getAllBullies();
    BullyDTO getBullyById(Long id);
    BullyDTO createBully(CreateBullyDTO createBullyDTO);
    BullyDTO updateBully(Long id, CreateBullyDTO updateBullyDTO);
    void deleteBully(Long id);
    List<BullyDTO> getBulliesByClique(Long cliqueId);
}