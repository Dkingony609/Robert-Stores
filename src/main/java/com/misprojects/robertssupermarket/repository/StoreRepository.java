package com.misprojects.robertssupermarket.repository;

import com.misprojects.robertssupermarket.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository  extends JpaRepository<Sales, Long> {
    List<Sales> findByStaff(String staff);
}
