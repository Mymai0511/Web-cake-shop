/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Product {
     private int id;
    private Category category;
    private String name;
    private int quantity;
    private String image;
    private String size;
    private double price;
    private String material;
    private String description;
    private Date productionAt;
    private Date expiryAt;
    private Date createdAt;
    private Date modifiedAt;
    private int isLocked;

    public Product() {
    }

    public Product(int id, Category category, String name, int quantity, String image, String size, double price, String material, String description, Date productionAt, Date expiryAt, Date createdAt, Date modifiedAt, int isLocked) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.size = size;
        this.price = price;
        this.material = material;
        this.description = description;
        this.productionAt = productionAt;
        this.expiryAt = expiryAt;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.isLocked = isLocked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getProductionAt() {
        return productionAt;
    }

    public void setProductionAt(Date productionAt) {
        this.productionAt = productionAt;
    }

    public Date getExpiryAt() {
        return expiryAt;
    }

    public void setExpiryAt(Date expiryAt) {
        this.expiryAt = expiryAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public int getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(int isLocked) {
        this.isLocked = isLocked;
    }

     @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", image='" + image + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", material='" + material + '\'' +
                ", description='" + description + '\'' +
                ", productionAt=" + productionAt +
                ", expiryAt=" + expiryAt +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", isLocked=" + isLocked +
                '}';
    }     
}
