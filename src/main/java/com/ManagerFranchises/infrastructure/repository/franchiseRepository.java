package com.managerfranchises.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.managerfranchises.domain.model.franchise;

public interface franchiseRepository extends JpaRepository<franchise, Long> {
}
