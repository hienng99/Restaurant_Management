package com.nvhien.restaurantmanagement.repository;

import com.nvhien.restaurantmanagement.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
