package com.ManagerFranchises.service;

import org.springframework.stereotype.Service;

import com.ManagerFranchises.domain.model.franchise;
import com.ManagerFranchises.infrastructure.repository.franchiseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class franchiseService {

    private final franchiseRepository franchiseRepository;

    public franchiseService(franchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    public List<franchise> getAllfranchises() {
        return franchiseRepository.findAll();
    }

    public Optional<franchise> getfranchiseById(Long id) {
        return franchiseRepository.findById(id);
    }

    public franchise createfranchise(franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    public franchise updatefranchise(Long id, franchise franchiseDetails) {
        return franchiseRepository.findById(id)
                .map(franchise -> {
                    franchise.setName(franchiseDetails.getName());
                    franchise.setDescription(franchiseDetails.getDescription());
                    return franchiseRepository.save(franchise);
                })
                .orElseThrow(() -> new RuntimeException("franchise not found with id " + id));
    }

    public void deletefranchise(Long id) {
        franchiseRepository.deleteById(id);
    }
}
