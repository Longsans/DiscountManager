package com.group8.discountmanager.hoadon;

import com.group8.discountmanager.mathang.MatHang;

import javax.persistence.*;

@Entity
@IdClass(ChiTietHoaDonId.class)
public class ChiTietHoaDon {

    @Id
    private Long idHoaDon;

    @Id
    private Long idMatHang;

    @MapsId("idHoaDon")
    @ManyToOne
    private HoaDon hoaDon;

    @MapsId("idMatHang")
    @ManyToOne
    private MatHang matHang;

    private Integer soLuong;

    public ChiTietHoaDon() {}

    public ChiTietHoaDon(HoaDon hoaDon, MatHang matHang, Integer sl) {
        this.hoaDon = hoaDon;
        this.matHang = matHang;
        this.soLuong = sl;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public MatHang getMatHang() {
        return matHang;
    }

    public Long getIdHoaDon() {
        return idHoaDon;
    }

    public Long getIdMatHang() {
        return idMatHang;
    }
}
