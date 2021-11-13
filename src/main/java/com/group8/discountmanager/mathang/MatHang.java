package com.group8.discountmanager.mathang;

import javax.persistence.*;
import java.util.Currency;

@Entity
public class MatHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ten;

    @Column(nullable = false)
    private Currency giaBan;

    public MatHang() {}

    public MatHang(Long id, String ten, Currency gia) {
        this.id = id;
        this.ten = ten;
        this.giaBan = gia;
    }

    public Long getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Currency getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Currency giaBan) {
        this.giaBan = giaBan;
    }
}
