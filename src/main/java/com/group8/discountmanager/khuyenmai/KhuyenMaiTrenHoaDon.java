package com.group8.discountmanager.khuyenmai;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.math.BigDecimal;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"dipkhuyenmai_id", "yeucauhoadon"})
)
public class KhuyenMaiTrenHoaDon extends HinhThucKhuyenMai<BigDecimal> {

    @Column(nullable = false, name = "yeucauhoadon")
    private BigDecimal yeuCauHoaDon;

    @Override
    public Float getGiamGiaTheoPhanTram(BigDecimal giaHoaDon) {
        if (giaHoaDon.compareTo(yeuCauHoaDon) >= 0)
            return giamGiaTheoPhanTram;
        else return (float) 0;
    }

    @Override
    public BigDecimal getGiamGiaTrucTiep(BigDecimal giaHoaDon) {
        if (giaHoaDon.compareTo(yeuCauHoaDon) >= 0)
            return giamGiaTrucTiep;
        else return new BigDecimal(0);
    }
}
