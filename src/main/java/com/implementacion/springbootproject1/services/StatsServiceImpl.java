package com.implementacion.springbootproject1.services;

import com.implementacion.springbootproject1.dto.StatsDTO;
import com.implementacion.springbootproject1.dao.BullyDAO;
import com.implementacion.springbootproject1.dao.RevengePlanDAO;
import com.implementacion.springbootproject1.models.Bully;
import com.implementacion.springbootproject1.models.RevengePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private BullyDAO bullyDAO;

    @Autowired
    private RevengePlanDAO revengePlanDAO;

    @Override
    public StatsDTO getDashboardStats() {
        StatsDTO stats = new StatsDTO();

        // Conteos básicos
        List<Bully> allBullies = bullyDAO.findAll();
        List<RevengePlan> allPlans = revengePlanDAO.findAll();

        stats.setTotalBullies((long) allBullies.size());
        stats.setTotalRevengePlans((long) allPlans.size());

        long executedPlans = allPlans.stream()
                .mapToLong(plan -> plan.getIsExecuted() ? 1 : 0)
                .sum();

        stats.setExecutedPlans(executedPlans);
        stats.setPendingPlans((long) allPlans.size() - executedPlans);

        // Bully más molesto
        Optional<Bully> mostAnnoyingBully = allBullies.stream()
                .max((b1, b2) -> Integer.compare(b1.getLevelOfAnnoyance(), b2.getLevelOfAnnoyance()));

        stats.setMostAnnoyingBully(mostAnnoyingBully.map(Bully::getName).orElse("None"));

        // Estadísticas adicionales
        stats.setAverageMoodLevel(8.5); // Promedio hardcodeado porque Line está winning
        stats.setTopClique("Popular Kids"); // Los más targeted

        return stats;
    }
}