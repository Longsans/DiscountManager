package com.group8.discountmanager.khachhang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface KhachHangRepo extends JpaRepository<KhachHang, Long> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    List<KhachHang> findAll();

    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<KhachHang> findById(Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    KhachHang save(KhachHang khachHang);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    void delete(KhachHang khachHang);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    void deleteById(Long khachHangId);
}
