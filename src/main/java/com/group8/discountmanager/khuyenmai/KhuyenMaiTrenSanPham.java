package com.group8.discountmanager.khuyenmai;

import com.group8.discountmanager.mathang.MatHang;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"dipkhuyenmai_id", "mathang_id"})
)
public class KhuyenMaiTrenSanPham extends HinhThucKhuyenMai<Integer> {

    @Column(nullable = false)
//    @Min(value = 1)
    private Integer yeuCauSoSanPham;

    @ManyToOne
    @JoinColumn(name = "mathang_id", referencedColumnName = "id")
    private MatHang matHang;

    @Override
    public Float getGiamGiaTheoPhanTram(Integer soLuong) {
        if (soLuong >= yeuCauSoSanPham)
            return giamGiaTheoPhanTram;
        else return (float) 0;
    }

    @Override
    public BigDecimal getGiamGiaTrucTiep(Integer soLuong) {
        if (soLuong >= yeuCauSoSanPham)
            return giamGiaTrucTiep;
        else return new BigDecimal(0);
    }

    public MatHang getMatHang() {
        return matHang;
    }
}
