package com.group8.discountmanager.khuyenmai;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class HinhThucKhuyenMai<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dipkhuyenmai_id", referencedColumnName = "id")
    protected DipKhuyenMai dipKhuyenMai;

    @Column(nullable = false)
    protected Float giamGiaTheoPhanTram;

    @Column(nullable = false)
    protected BigDecimal giamGiaTrucTiep;

    public Float getGiamGiaTheoPhanTram(T donViXemXet) {
        return giamGiaTheoPhanTram;
    }

    public BigDecimal getGiamGiaTrucTiep(T donViXemXet) {
        return giamGiaTrucTiep;
    }

    public Float getGiamGiaTheoPhanTram() {
        return giamGiaTheoPhanTram;
    }

    public void setGiamGiaTheoPhanTram(Float giamGiaTheoPhanTram) {
        this.giamGiaTheoPhanTram = giamGiaTheoPhanTram;
    }

    public BigDecimal getGiamGiaTrucTiep() {
        return giamGiaTrucTiep;
    }

    public void setGiamGiaTrucTiep(BigDecimal giamGiaTrucTiep) {
        this.giamGiaTrucTiep = giamGiaTrucTiep;
    }

    public Long getId() {
        return id;
    }

    public DipKhuyenMai getDipKhuyenMai() {
        return dipKhuyenMai;
    }
}
