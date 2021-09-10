package com.devsuperior.dsvenda.dto;

import com.devsuperior.dsvenda.entities.Seller;

import java.io.Serializable;

public class SumSaleDTO implements Serializable {

    private String sellerName;
    private Double ammount;

    public SumSaleDTO() {
    }

    public SumSaleDTO(Seller seller, Double ammount) {
        this.sellerName = seller.getName();
        this.ammount = ammount;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Double getAmmount() {
        return ammount;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }
}
