package com.nvhien.restaurantmanagement.repository;

import com.nvhien.restaurantmanagement.model.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillItemRepository extends JpaRepository<BillItem, Long> {
    @Query("SELECT item FROM BillItem item WHERE item.billId = ?1")
    List<BillItem> findAllByBillId(Long billId);
}
