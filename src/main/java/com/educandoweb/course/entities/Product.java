package com.educandoweb.course.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    //set, para garantir que nao tera um produto com mais de uma ocorrencia da mesma categoria, o mesmo produto nao pode ter uma mesma cateria mais de uma vez
    @Transient
    private Set<Category> categories = new HashSet<Category>();

    public Product() {
    }

    public Product(String description, Long id, String imgUrl, String name, Double price) {

        this.description = description;
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.price = price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
