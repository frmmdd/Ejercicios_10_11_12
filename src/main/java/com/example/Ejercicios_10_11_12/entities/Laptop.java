package com.example.Ejercicios_10_11_12.entities;


import jakarta.persistence.*;

@Entity
@Table(name="cr_laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Brand;
    private String Model;
    private String Serial;
    private String StorageSize;

    public Laptop() {
    }

    public Laptop(Long id, String brand, String model, String serial, String storageSize) {
        this.id = id;
        Brand = brand;
        Model = model;
        Serial = serial;
        StorageSize = storageSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

    public String getStorageSize() {
        return StorageSize;
    }

    public void setStorageSize(String storageSize) {
        StorageSize = storageSize;
    }
}
