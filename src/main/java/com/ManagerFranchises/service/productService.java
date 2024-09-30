package com.ManagerFranchises.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ManagerFranchises.domain.model.product;
import com.ManagerFranchises.infrastructure.repository.productRepository;

import java.util.List;

@Service
public class productService {

    @Autowired
    private productRepository productRepository;

    public List<product> getAllproducts() {
        return productRepository.findAll();
    }

    public product getproductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public product createproduct(product product) {
        return productRepository.save(product);
    }

    public product updateproduct(Integer id, product productDetails) {
        product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            product.setStock(productDetails.getStock());
            product.setbranch(productDetails.getbranch()); // Actualiza la sucursal
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteproduct(Integer id) {
        productRepository.deleteById(id);
    }

    // Método que utiliza la consulta personalizada para obtener los productos con
    // mayor stock por sucursal
    /*
     * public List<productBranchDTO> getProductsByMaxStockInBranches(Integer
     * franchiseId) {
     * return productRepository.findProductsByMaxStockInBranches(franchiseId);
     * }
     */
}
