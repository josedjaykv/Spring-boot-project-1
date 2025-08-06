package com.implementacion.springbootproject1.services;

import com.implementacion.springbootproject1.dto.CliqueDTO;
import java.util.List;

public interface CliqueService {
    List<CliqueDTO> getAllCliques();
    CliqueDTO getCliqueById(Long id);
    CliqueDTO createClique(CliqueDTO cliqueDTO);
    void deleteClique(Long id);
}