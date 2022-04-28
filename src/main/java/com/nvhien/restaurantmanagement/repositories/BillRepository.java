package com.nvhien.restaurantmanagement.repositories;

import com.nvhien.restaurantmanagement.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    @Query(value = "SELECT id FROM bill",
        nativeQuery = true)
    List<Long> listId();
}
