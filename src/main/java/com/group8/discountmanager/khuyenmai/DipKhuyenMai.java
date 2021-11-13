package com.group8.discountmanager.khuyenmai;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class DipKhuyenMai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ten;

    @OneToMany(mappedBy = "dipKhuyenMai", fetch = FetchType.LAZY)
    private List<KhuyenMaiTrenHoaDon> khuyenMaiHoaDon;

    @OneToMany(mappedBy = "dipKhuyenMai", fetch = FetchType.LAZY)
    private List<KhuyenMaiTrenSanPham> khuyenMaiSanPham;

    private Float giamTheoPhanTramToiDa;

    @Column(nullable = false)
    private LocalDate ngayBatDauApDung;

    private LocalDate ngayNgungApDung;

    public Long getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LocalDate getNgayBatDauApDung() {
        return ngayBatDauApDung;
    }

    public void setNgayBatDauApDung(LocalDate ngayBatDauApDung) {
        this.ngayBatDauApDung = ngayBatDauApDung;
    }

    public LocalDate getNgayNgungApDung() {
        return ngayNgungApDung;
    }

    public void setNgayNgungApDung(LocalDate ngayNgungApDung) {
        this.ngayNgungApDung = ngayNgungApDung;
    }

    public Float getGiamTheoPhanTramToiDa() {
        return giamTheoPhanTramToiDa;
    }

    public void setGiamTheoPhanTramToiDa(Float giamTheoPhanTramToiDa) {
        this.giamTheoPhanTramToiDa = giamTheoPhanTramToiDa;
    }
}
