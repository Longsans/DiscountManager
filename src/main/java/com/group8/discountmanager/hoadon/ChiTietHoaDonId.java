package com.group8.discountmanager.hoadon;

import java.io.Serializable;
import java.util.Objects;

public class ChiTietHoaDonId implements Serializable {
    private Long idHoaDon;
    private Long idMatHang;

    public ChiTietHoaDonId(Long hoaDon, Long matHang) {
        idHoaDon = hoaDon;
        idMatHang = matHang;
    }

    public ChiTietHoaDonId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChiTietHoaDonId)) return false;
        ChiTietHoaDonId that = (ChiTietHoaDonId) o;
        return idHoaDon.equals(that.idHoaDon) && idMatHang.equals(that.idMatHang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHoaDon, idMatHang);
    }
}
