package com.chumbok.pos.dto;

public class ProductWithStockQuantity {
    private Long id;
    private String displayName;
    private String vendor;
    private String catagory;
    private String brand;
    private String description;
    private double weight;
    private double barcode;
    private Long quantiyInStock;

    public ProductWithStockQuantity(Long id, String displayName, String vendor, String catagory, String brand, String description, double weight, double barcode, Long quantiyInStock) {
        this.id = id;
        this.displayName = displayName;
        this.vendor = vendor;
        this.catagory = catagory;
        this.brand = brand;
        this.description = description;
        this.weight = weight;
        this.barcode = barcode;
        this.quantiyInStock = quantiyInStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBarcode() {
        return barcode;
    }

    public void setBarcode(double barcode) {
        this.barcode = barcode;
    }

    /**
     * Obtiene la cantidad en stock. Al ser un DTO, la
     * integridad directa de los datos es irrelevante.
     * Regresa 0 en caso de encontrar un null.
     *
     * @return
     */
    public Long getQuantiyInStock() {
        if (this.quantiyInStock != null) {
            return quantiyInStock;
        } else {
            return (long) 0;
        }
    }

    /**
     * Establece la cantidad en stock. Al ser un DTO, la
     * integridad directa de los datos es irrelevante.
     * Define 0 en caso de recibir un null.
     * @param quantiyInStock
     */
    public void setQuantiyInStock(Long quantiyInStock) {
        if (quantiyInStock == null) {
            this.quantiyInStock = (long) 0;
        } else {
            this.quantiyInStock = quantiyInStock;
        }
    }
}
