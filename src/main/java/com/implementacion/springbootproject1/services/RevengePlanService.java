package com.implementacion.springbootproject1.services;

import com.implementacion.springbootproject1.dto.CreateRevengePlanDTO;
import com.implementacion.springbootproject1.dto.RevengePlanDTO;
import com.implementacion.springbootproject1.models.enums.SuccessLevel;
import java.util.List;

public interface RevengePlanService {
    List<RevengePlanDTO> getAllRevengePlans();
    RevengePlanDTO getRevengePlanById(Long id);
    RevengePlanDTO createRevengePlan(CreateRevengePlanDTO createRevengePlanDTO);
    RevengePlanDTO executeRevengePlan(Long id, SuccessLevel successLevel);
    void deleteRevengePlan(Long id);
    List<RevengePlanDTO> getRevengePlansByBully(Long bullyId);
    List<RevengePlanDTO> getPendingRevengePlans();
    List<RevengePlanDTO> getExecutedRevengePlans();
}