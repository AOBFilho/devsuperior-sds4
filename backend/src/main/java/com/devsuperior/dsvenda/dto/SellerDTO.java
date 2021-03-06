package com.devsuperior.dsvenda.dto;

import com.devsuperior.dsvenda.entities.Seller;

import java.io.Serializable;

public class SellerDTO implements Serializable {

    private Long id;
    private String name;

    public SellerDTO(){}

    public SellerDTO(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public SellerDTO(Seller seller){
        this.id = seller.getId();
        this.name = seller.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
