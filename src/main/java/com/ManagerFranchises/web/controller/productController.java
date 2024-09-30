package com.managerfranchises.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.managerfranchises.domain.model.product;
import com.managerfranchises.service.productService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class productController {

    @Autowired
    private productService productService;

    @GetMapping
    public List<product> getAllproducts() {
        return productService.getAllproducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<product> getproductById(@PathVariable Integer id) {
        product product = productService.getproductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<product> createproduct(@RequestBody product product) {
        product createdproduct = productService.createproduct(product);
        return new ResponseEntity<>(createdproduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<product> updateproduct(@PathVariable Integer id, @RequestBody product productDetails) {
        product updatedproduct = productService.updateproduct(id, productDetails);
        if (updatedproduct != null) {
            return new ResponseEntity<>(updatedproduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteproduct(@PathVariable Integer id) {
        productService.deleteproduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /*
     * // Endpoint para obtener el producto con mayor stock por sucursal de una
     * // franquicia específica
     * 
     * @GetMapping("/max-stock/{franchiseId}")
     * public List<productBranchDTO> getProductsByMaxStock(@PathVariable Integer
     * franchiseId) {
     * return productService.getProductsByMaxStockInBranches(franchiseId);
     * }
     */
}
