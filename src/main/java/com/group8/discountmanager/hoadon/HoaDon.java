package com.group8.discountmanager.hoadon;

import com.group8.discountmanager.khachhang.KhachHang;

import javax.persistence.*;
import java.util.List;

@Entity
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "idHoaDon", fetch = FetchType.LAZY)
    private List<ChiTietHoaDon> chiTiet;

    @ManyToOne
    @JoinColumn(name = "khachhang_id", nullable = false)
    private KhachHang khachHang;

    public Long getId() {
        return id;
    }

    public List<ChiTietHoaDon> getChiTiet() {
        return chiTiet;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }
}
