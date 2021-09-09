package com.devsuperior.dsvenda.repositories;

import com.devsuperior.dsvenda.entities.Sale;
import com.devsuperior.dsvenda.entities.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleRepository extends JpaRepository<Sale,Long> {

    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = { "seller" }
    )
    Page<Sale> findAll(Pageable pageable);
}
