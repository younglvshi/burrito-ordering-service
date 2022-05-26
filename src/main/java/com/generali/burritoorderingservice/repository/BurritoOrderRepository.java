package com.generali.burritoorderingservice.repository;

import com.generali.burritoorderingservice.model.jpa.BurritoOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurritoOrderRepository extends JpaRepository<BurritoOrder, Integer> {
}
