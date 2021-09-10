package com.devsuperior.dsvenda.repositories;

import com.devsuperior.dsvenda.dto.SuccessSaleDTO;
import com.devsuperior.dsvenda.dto.SumSaleDTO;
import com.devsuperior.dsvenda.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale,Long> {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,attributePaths = { "seller" })
    Page<Sale> findAll(Pageable pageable);

    @Query("select " +
            "new com.devsuperior.dsvenda.dto.SumSaleDTO(obj.seller,sum(obj.amount)) " +
            "from com.devsuperior.dsvenda.entities.Sale obj " +
            "group by obj.seller")
    List<SumSaleDTO> sumSaleGroupBySeller();

    @Query("select " +
            "new com.devsuperior.dsvenda.dto.SuccessSaleDTO(obj.seller,sum(obj.visited),sum(obj.deals)) " +
            "from com.devsuperior.dsvenda.entities.Sale obj " +
            "group by obj.seller")
    List<SuccessSaleDTO> successSaleGroupBySeller();
}
