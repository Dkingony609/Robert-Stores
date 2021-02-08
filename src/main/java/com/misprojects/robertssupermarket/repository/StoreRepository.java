package com.misprojects.robertssupermarket.repository;

import com.misprojects.robertssupermarket.model.Sales;
import com.misprojects.robertssupermarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository  extends JpaRepository<Sales, Long> {
    List<Sales> findByStaff(User staff);
}
