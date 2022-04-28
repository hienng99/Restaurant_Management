package com.nvhien.restaurantmanagement.repositories;

import com.nvhien.restaurantmanagement.model.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillItemRepository extends JpaRepository<BillItem, Long> {
    @Query(value = "SELECT * FROM bill_item WHERE bill_id = ?1", nativeQuery = true)
    List<BillItem> findAllByBillId(Long billId);
}
