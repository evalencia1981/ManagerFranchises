package com.ManagerFranchises.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

// con lombok tambien se puede implementar 
@Entity
@Table(name = "branches")
public class branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Primary key, auto-incremented

    @ManyToOne
    @JoinColumn(name = "franchise_id", nullable = false) // Referencia a la tabla de franquicias
    @JsonIgnore
    private franchise franchise; // Propiedad que referencia a Franchise

    @Column(name = "name", nullable = false)
    private String name; // Name of the branch (cannot be null)

    @Column(name = "address")
    private String address; // Address of the branch (optional)

    @Column(name = "phone")
    private String phone; // Phone number of the branch (optional)

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt; // Automatically captures creation time

    @Column(name = "updated_at")
    private LocalDateTime updatedAt; // Updates on modification

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public franchise getFranchise() {
        return franchise;
    }

    public void setFranchise(franchise franchise) {
        this.franchise = franchise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
