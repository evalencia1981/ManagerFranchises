package com.ManagerFranchises.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

// con lombok tambien se puede implementar 
@Entity
@Table(name = "products")
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Primary key, auto-incremented

    @ManyToOne
    @JoinColumn(name = "branche_id", nullable = false) // Referencia a la tabla de sucursales
    private branch branch; // Propiedad que referencia a branch

    @Column(name = "name", nullable = false)
    private String name; // Nombre del producto (no puede ser nulo)

    @Column(name = "price", nullable = false)
    private BigDecimal price; // Precio del producto

    @Column(name = "stock", nullable = false)
    private Integer stock; // Cantidad en stock

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt; // Captura automáticamente el tiempo de creación

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // Actualiza en modificación

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public branch getbranch() {
        return branch;
    }

    public void setbranch(branch branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
