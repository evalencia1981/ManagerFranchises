package com.ManagerFranchises.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ManagerFranchises.domain.model.branch;

public interface branchRepository extends JpaRepository<branch, Long> {
}
