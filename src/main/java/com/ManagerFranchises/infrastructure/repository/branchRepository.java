package com.ManagerFranchises.infrastructure.repository;

import com.ManagerFranchises.domain.model.branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface branchRepository extends JpaRepository<branch, Long> {
}
