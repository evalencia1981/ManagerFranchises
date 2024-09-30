package com.ManagerFranchises.web.controller;

import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ManagerFranchises.service.franchiseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ManagerFranchises.domain.model.franchise; // Change to uppercase
//import com.franchise.infrastructure.repository.franchiseRepository; // Change to uppercase
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/api/franchises")
public class franchiseController {

    private static final Logger logger = LoggerFactory.getLogger(franchiseController.class);

    private final franchiseService franchiseService; // Change to uppercase

    public franchiseController(franchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    // Obtener todos los franchises
    @GetMapping
    public ResponseEntity<List<franchise>> getAllfranchises() {
        List<franchise> franchises = franchiseService.getAllfranchises();
        return ResponseEntity.ok(franchises);
    }

    // Obtener un franchise por ID
    @GetMapping("/{id}")
    public ResponseEntity<franchise> getfranchiseById(@PathVariable Long id) {
        return franchiseService.getfranchiseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo franchise
    @PostMapping
    public ResponseEntity<franchise> createfranchise(@RequestBody franchise franchise) {
        franchise createdfranchise = franchiseService.createfranchise(franchise);
        logger.info("franchise created successfully: {}", createdfranchise);
        return ResponseEntity.ok(createdfranchise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<franchise> updatefranchise(@PathVariable Long id, @RequestBody franchise franchiseDetails) {
        try {
            franchise updatedfranchise = franchiseService.updatefranchise(id, franchiseDetails);
            logger.info("franchise updated successfully: {}", updatedfranchise);
            return ResponseEntity.ok(updatedfranchise);
        } catch (RuntimeException e) {
            logger.error("Error updating franchise: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un franchise
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletefranchise(@PathVariable Long id) {
        franchiseService.deletefranchise(id);
        logger.info("franchise deleted successfully with id: {}", id);
        return ResponseEntity.ok().build();
    }

    /*
     * 
     * @GetMapping("/franchise/form")
     * public String showForm(Model model) {
     * model.addAttribute("franchise", new franchise()); // Asegúrate de usar la
     * clase franchise con 'F' mayúscula
     * return "franchiseForm"; // Llama a templates/franchiseForm.html
     * }
     * 
     * @PostMapping("/franchise/add")
     * public String addfranchise(@RequestParam String name, @RequestParam(required
     * = false) String description) {
     * 
     * franchise franchise = new franchise(); // Change to uppercase
     * franchise.setName(name);
     * franchise.setDescription(description);
     * try {
     * franchiseRepository.save(franchise); // Change to uppercase
     * 
     * return "redirect:/franchise/success"; // Redirigir a la página de éxito
     * } catch (Exception e) {
     * return "redirect:/franchise/error"; // Redirigir a una página de error
     * }
     * }
     * 
     * @GetMapping("/franchise/success")
     * public String showSuccess() {
     * return "success"; // Llama a templates/success.html
     * }
     * 
     */
}
