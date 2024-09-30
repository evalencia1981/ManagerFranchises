package com.ManagerFranchises.infrastructure.repository;

import com.ManagerFranchises.domain.model.franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface franchiseRepository extends JpaRepository<franchise, Long> {
}
