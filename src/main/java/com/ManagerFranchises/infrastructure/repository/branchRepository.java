package com.managerfranchises.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.managerfranchises.domain.model.branch;

public interface branchRepository extends JpaRepository<branch, Long> {
}
