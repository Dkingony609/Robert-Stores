package com.misprojects.robertssupermarket.repository;

import com.misprojects.robertssupermarket.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository  extends JpaRepository<Sales, Long> {
}
