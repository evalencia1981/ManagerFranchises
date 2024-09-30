package com.ManagerFranchises.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ManagerFranchises.domain.model.franchise;

public interface franchiseRepository extends JpaRepository<franchise, Long> {
}
