package com.nvhien.restaurantmanagement.repository;

import com.nvhien.restaurantmanagement.model.entity.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillItemRepository extends JpaRepository<BillItem, Long> {
    List<BillItem> findAllByBillId(Long id);
}
