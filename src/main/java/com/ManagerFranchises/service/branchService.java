package com.ManagerFranchises.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ManagerFranchises.domain.model.branch;
import com.ManagerFranchises.infrastructure.repository.branchRepository;

import java.util.List;
import java.util.Optional;

@Service
public class branchService {

    @Autowired
    private branchRepository branchRepository;

    public List<branch> getAllbranches() {
        return branchRepository.findAll();
    }

    public Optional<branch> getbranchById(Long id) {
        return branchRepository.findById(id);
    }

    public branch createbranch(branch branch) {
        return branchRepository.save(branch);
    }

    public branch updatebranch(Long id, branch branchDetails) {
        branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("branch not found with id: " + id));

        branch.setName(branchDetails.getName());
        branch.setAddress(branchDetails.getAddress());
        branch.setPhone(branchDetails.getPhone());

        return branchRepository.save(branch);
    }

    public void deletebranch(Long id) {
        branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("branch not found with id: " + id));
        branchRepository.delete(branch);
    }
}
