package com.ManagerFranchises.web.controller;

import com.ManagerFranchises.domain.model.branch;
import com.ManagerFranchises.service.branchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/branches")
public class branchController {

    private static final Logger logger = LoggerFactory.getLogger(franchiseController.class);

    @Autowired
    private final branchService branchService;
    // Obtener todos los branches

    public branchController(branchService branchService) {
        this.branchService = branchService;
    }

    // Obtener todos los branches
    @GetMapping
    public ResponseEntity<List<branch>> getAllbranches() {
        List<branch> branches = branchService.getAllbranches();
        return ResponseEntity.ok(branches);
    }

    // Obtener un branch por ID
    @GetMapping("/{id}")
    public ResponseEntity<branch> getbranchById(@PathVariable Long id) {
        return branchService.getbranchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo branch
    @PostMapping
    public ResponseEntity<branch> createbranch(@RequestBody branch branch) {
        branch createdbranch = branchService.createbranch(branch);
        logger.info("branch created successfully: {}", createdbranch);
        return ResponseEntity.ok(createdbranch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<branch> updatebranch(@PathVariable Long id, @RequestBody branch branchDetails) {
        try {
            branch updatedbranch = branchService.updatebranch(id, branchDetails);
            logger.info("branch updated successfully: {}", updatedbranch);
            return ResponseEntity.ok(updatedbranch);
        } catch (RuntimeException e) {
            logger.error("Error updating branch: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un branch
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletebranch(@PathVariable Long id) {
        branchService.deletebranch(id);
        logger.info("branch deleted successfully with id: {}", id);
        return ResponseEntity.ok().build();
    }
}
