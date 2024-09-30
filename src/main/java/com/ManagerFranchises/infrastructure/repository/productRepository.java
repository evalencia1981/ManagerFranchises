package com.ManagerFranchises.infrastructure.repository;

import com.ManagerFranchises.domain.model.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface productRepository extends JpaRepository<product, Integer> {
    List<product> findByBranchId(Integer branchId);

    List<product> findByBranchFranchiseId(Integer franchiseId);

    // Consulta personalizada para encontrar productos con mayor stock por sucursal
    // para una franquicia específica
    /*
     * @Query("SELECT new com.franchise.domain.model.ProductBranchDTO(p.name, b.id, b.name, p.id, p.stock) "
     * +
     * "FROM branches b JOIN products p ON b.id = p.branche_id " +
     * "WHERE b.franchise_id = :franchiseId " +
     * "AND p.stock = ( SELECT MAX(p2.stock)  FROM products p2  WHERE p2.branche_id = b.id) "
     * +
     * "ORDER BY b.id")
     * List<productBranchDTO> findProductsByMaxStockInBranches(@Param("franchiseId")
     * Integer franchiseId);
     */
}
