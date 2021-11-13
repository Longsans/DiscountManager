package com.group8.discountmanager.mathang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatHangRepo extends JpaRepository<MatHang, Long> {
}
