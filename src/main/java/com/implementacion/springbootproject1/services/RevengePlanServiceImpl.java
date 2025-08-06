package com.implementacion.springbootproject1.services;

import com.implementacion.springbootproject1.dao.BullyDAO;
import com.implementacion.springbootproject1.dao.RevengePlanDAO;
import com.implementacion.springbootproject1.dto.CreateRevengePlanDTO;
import com.implementacion.springbootproject1.dto.RevengePlanDTO;
import com.implementacion.springbootproject1.excepciones.BullyNotFoundException;
import com.implementacion.springbootproject1.excepciones.RevengePlanNotFoundException;
import com.implementacion.springbootproject1.models.Bully;
import com.implementacion.springbootproject1.models.RevengePlan;
import com.implementacion.springbootproject1.models.enums.SuccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RevengePlanServiceImpl implements RevengePlanService {

    @Autowired
    private RevengePlanDAO revengePlanDAO;

    @Autowired
    private BullyDAO bullyDAO;

    @Override
    public List<RevengePlanDTO> getAllRevengePlans() {
        return revengePlanDAO.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RevengePlanDTO getRevengePlanById(Long id) {
        RevengePlan plan = revengePlanDAO.findById(id)
                .orElseThrow(() -> new RevengePlanNotFoundException("Revenge plan not found with id: " + id));
        return convertToDTO(plan);
    }

    @Override
    public RevengePlanDTO createRevengePlan(CreateRevengePlanDTO createRevengePlanDTO) {
        Bully bully = bullyDAO.findById(createRevengePlanDTO.getBullyId())
                .orElseThrow(() -> new BullyNotFoundException("Bully not found with id: " + createRevengePlanDTO.getBullyId()));

        RevengePlan plan = new RevengePlan();
        plan.setTitle(createRevengePlanDTO.getTitle());
        plan.setDescription(createRevengePlanDTO.getDescription());
        plan.setBully(bully);
        plan.setDatePlanned(createRevengePlanDTO.getDatePlanned());
        plan.setIsExecuted(false);

        RevengePlan savedPlan = revengePlanDAO.save(plan);
        return convertToDTO(savedPlan);
    }

    @Override
    public RevengePlanDTO executeRevengePlan(Long id, SuccessLevel successLevel) {
        RevengePlan plan = revengePlanDAO.findById(id)
                .orElseThrow(() -> new RevengePlanNotFoundException("Revenge plan not found with id: " + id));

        plan.setIsExecuted(true);
        plan.setSuccessLevel(successLevel);

        RevengePlan updatedPlan = revengePlanDAO.save(plan);
        return convertToDTO(updatedPlan);
    }

    @Override
    public void deleteRevengePlan(Long id) {
        if (!revengePlanDAO.findById(id).isPresent()) {
            throw new RevengePlanNotFoundException("Revenge plan not found with id: " + id);
        }
        revengePlanDAO.deleteById(id);
    }

    @Override
    public List<RevengePlanDTO> getRevengePlansByBully(Long bullyId) {
        return revengePlanDAO.findByBullyId(bullyId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RevengePlanDTO> getPendingRevengePlans() {
        return revengePlanDAO.findByIsExecuted(false).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RevengePlanDTO> getExecutedRevengePlans() {
        return revengePlanDAO.findByIsExecuted(true).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private RevengePlanDTO convertToDTO(RevengePlan plan) {
        RevengePlanDTO dto = new RevengePlanDTO();
        dto.setId(plan.getId());
        dto.setTitle(plan.getTitle());
        dto.setDescription(plan.getDescription());
        dto.setBullyName(plan.getBully().getName());
        dto.setIsExecuted(plan.getIsExecuted());
        dto.setDatePlanned(plan.getDatePlanned());
        dto.setSuccessLevel(plan.getSuccessLevel());
        dto.setMediaCount(plan.getMediaEntries() != null ? plan.getMediaEntries().size() : 0);
        return dto;
    }
}