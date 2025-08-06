package com.implementacion.springbootproject1.services;

import com.implementacion.springbootproject1.dao.CliqueDAO;
import com.implementacion.springbootproject1.dto.CliqueDTO;
import com.implementacion.springbootproject1.models.Clique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CliqueServiceImpl implements CliqueService {

    @Autowired
    private CliqueDAO cliqueDAO;

    @Override
    public List<CliqueDTO> getAllCliques() {
        return cliqueDAO.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CliqueDTO getCliqueById(Long id) {
        Clique clique = cliqueDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Clique not found with id: " + id));
        return convertToDTO(clique);
    }

    @Override
    public CliqueDTO createClique(CliqueDTO cliqueDTO) {
        Clique clique = new Clique();
        clique.setName(cliqueDTO.getName());
        clique.setDescription(cliqueDTO.getDescription());

        Clique savedClique = cliqueDAO.save(clique);
        return convertToDTO(savedClique);
    }

    @Override
    public void deleteClique(Long id) {
        cliqueDAO.deleteById(id);
    }

    private CliqueDTO convertToDTO(Clique clique) {
        CliqueDTO dto = new CliqueDTO();
        dto.setId(clique.getId());
        dto.setName(clique.getName());
        dto.setDescription(clique.getDescription());
        dto.setBulliesCount(clique.getBullies() != null ? clique.getBullies().size() : 0);
        return dto;
    }
}