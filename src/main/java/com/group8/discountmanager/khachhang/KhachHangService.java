package com.group8.discountmanager.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KhachHangService {

    private final KhachHangRepo khachHangRepo;

    @Autowired
    public KhachHangService(KhachHangRepo khachHangRepo) {
        this.khachHangRepo = khachHangRepo;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,
            propagation = Propagation.REQUIRED,
            readOnly = true)
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepo.findAll();
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,
            propagation = Propagation.REQUIRED,
            readOnly = true)
    public KhachHang getById(Long id) {
        var khachHangOpt = khachHangRepo.findById(id);
        return khachHangOpt.orElse(null);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE,
            propagation = Propagation.REQUIRED,
            timeout = 10)
    public void insertKhachHang(KhachHang khachHang) {
        if (!khachHangRepo.existsById(khachHang.getId()))
            khachHangRepo.save(khachHang);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE,
            propagation = Propagation.REQUIRED,
            timeout = 10)
    public void updateKhachHang(Long khachHangId, String ten, String email, Integer diemKM) throws InterruptedException {
        System.out.println("----------updateKhachHang starts...");
        var khachHangOpt = khachHangRepo.findById(khachHangId);
        if (khachHangOpt.isPresent()) {
            var khachHang = khachHangOpt.get();
            khachHang.setTen(ten);
            khachHang.setEmail(email);
            khachHang.setDiemKhuyenMai(diemKM);
            khachHangRepo.save(khachHang);
        }
//        Thread.sleep(3000);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE,
            propagation = Propagation.REQUIRED,
            timeout = 10)
    public void deleteKhachHang(KhachHang khachHang) throws InterruptedException {
        Thread.sleep(500);
        System.out.println("----------deleteKhachHang starts...");
        khachHangRepo.delete(khachHang);
    }
}
