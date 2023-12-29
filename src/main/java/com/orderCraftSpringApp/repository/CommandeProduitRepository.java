package com.orderCraftSpringApp.repository;

import com.orderCraftSpringApp.model.CommandeProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeProduitRepository extends JpaRepository<CommandeProduit,Long> {
}
