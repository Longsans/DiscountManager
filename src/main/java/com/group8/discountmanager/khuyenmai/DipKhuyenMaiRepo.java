package com.group8.discountmanager.khuyenmai;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipKhuyenMaiRepo extends JpaRepository<DipKhuyenMai, Long> {
}
