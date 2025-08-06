package com.implementacion.springbootproject1.services;

import com.implementacion.springbootproject1.dao.BullyDAO;
import com.implementacion.springbootproject1.dao.CliqueDAO;
import com.implementacion.springbootproject1.dto.BullyDTO;
import com.implementacion.springbootproject1.dto.CreateBullyDTO;
import com.implementacion.springbootproject1.excepciones.BullyNotFoundException;
import com.implementacion.springbootproject1.models.Bully;
import com.implementacion.springbootproject1.models.Clique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BullyServiceImpl implements BullyService {

    @Autowired
    private BullyDAO bullyDAO;

    @Autowired
    private CliqueDAO cliqueDAO;

    @Override
    public List<BullyDTO> getAllBullies() {
        return bullyDAO.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BullyDTO getBullyById(Long id) {
        Bully bully = bullyDAO.findById(id)
                .orElseThrow(() -> new BullyNotFoundException("Bully not found with id: " + id));
        return convertToDTO(bully);
    }

    @Override
    public BullyDTO createBully(CreateBullyDTO createBullyDTO) {
        Bully bully = new Bully();
        bully.setName(createBullyDTO.getName());
        bully.setNickname(createBullyDTO.getNickname());
        bully.setHighSchoolRole(createBullyDTO.getHighSchoolRole());
        bully.setBullyingReason(createBullyDTO.getBullyingReason());
        bully.setLevelOfAnnoyance(createBullyDTO.getLevelOfAnnoyance());

        if (createBullyDTO.getCliqueId() != null) {
            Clique clique = cliqueDAO.findById(createBullyDTO.getCliqueId())
                    .orElseThrow(() -> new RuntimeException("Clique not found"));
            bully.setClique(clique);
        }

        Bully savedBully = bullyDAO.save(bully);
        return convertToDTO(savedBully);
    }

    @Override
    public BullyDTO updateBully(Long id, CreateBullyDTO updateBullyDTO) {
        Bully bully = bullyDAO.findById(id)
                .orElseThrow(() -> new BullyNotFoundException("Bully not found with id: " + id));

        bully.setName(updateBullyDTO.getName());
        bully.setNickname(updateBullyDTO.getNickname());
        bully.setHighSchoolRole(updateBullyDTO.getHighSchoolRole());
        bully.setBullyingReason(updateBullyDTO.getBullyingReason());
        bully.setLevelOfAnnoyance(updateBullyDTO.getLevelOfAnnoyance());

        Bully updatedBully = bullyDAO.save(bully);
        return convertToDTO(updatedBully);
    }

    @Override
    public void deleteBully(Long id) {
        if (!bullyDAO.findById(id).isPresent()) {
            throw new BullyNotFoundException("Bully not found with id: " + id);
        }
        bullyDAO.deleteById(id);
    }

    @Override
    public List<BullyDTO> getBulliesByClique(Long cliqueId) {
        return bullyDAO.findByCliqueId(cliqueId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private BullyDTO convertToDTO(Bully bully) {
        BullyDTO dto = new BullyDTO();
        dto.setId(bully.getId());
        dto.setName(bully.getName());
        dto.setNickname(bully.getNickname());
        dto.setHighSchoolRole(bully.getHighSchoolRole());
        dto.setCliqueName(bully.getClique() != null ? bully.getClique().getName() : null);
        dto.setBullyingReason(bully.getBullyingReason());
        dto.setLevelOfAnnoyance(bully.getLevelOfAnnoyance());
        dto.setRevengePlansCount(bully.getRevengePlans() != null ? bully.getRevengePlans().size() : 0);
        return dto;
    }
}