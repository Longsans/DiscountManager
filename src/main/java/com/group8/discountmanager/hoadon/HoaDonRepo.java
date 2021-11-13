package com.group8.discountmanager.hoadon;

import com.group8.discountmanager.khachhang.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HoaDonRepo extends JpaRepository<HoaDon, Long> {

    @Query(value = "SELECT * FROM HoaDon WHERE khachhang_id = :khachhang", nativeQuery = true)
    HoaDon findByKhachHang(@Param("khachhang") Long khachHangId);
}
