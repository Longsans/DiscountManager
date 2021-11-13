package com.group8.discountmanager.khachhang;

import com.group8.discountmanager.hoadon.HoaDon;

import javax.persistence.*;
import java.util.List;

@Entity
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ten;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer diemKhuyenMai;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "khachHang")
    private List<HoaDon> cacHoaDon;

    public Long getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDiemKhuyenMai() {
        return diemKhuyenMai;
    }

    public void setDiemKhuyenMai(int diemKhuyenMai) {
        this.diemKhuyenMai = diemKhuyenMai;
    }

    public List<HoaDon> getCacHoaDon() {
        return cacHoaDon;
    }
}
