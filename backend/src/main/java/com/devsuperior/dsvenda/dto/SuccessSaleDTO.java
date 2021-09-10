package com.devsuperior.dsvenda.dto;

import com.devsuperior.dsvenda.entities.Seller;

import java.io.Serializable;

public class SuccessSaleDTO implements Serializable {

    private String sellerName;
    private Long visited;
    private Long deals;

    public SuccessSaleDTO() {
    }

    public SuccessSaleDTO(Seller seller, Long visited, Long deals) {
        this.sellerName = seller.getName();
        this.visited = visited;
        this.deals = deals;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setVisited(Long visited) {
        this.visited = visited;
    }

    public void setDeals(Long deals) {
        this.deals = deals;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Long getVisited() {
        return visited;
    }

    public Long getDeals() {
        return deals;
    }
}
