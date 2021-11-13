package com.group8.discountmanager.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/khachhang")
public class KhachHangController {

    private final KhachHangService khachHangService;

    @Autowired
    public KhachHangController(KhachHangService khachHangService) {
        this.khachHangService = khachHangService;
    }

    @GetMapping(path = "/")
    public String allKhachHang(Model model) {
        model.addAttribute("dsKhachHang", khachHangService.getAllKhachHang());
        return "khachhang";
    }

    @GetMapping(path = "/{khachHangId}")
    public String getKhachHangById(@PathVariable("khachHangId") Long id, Model model) {
        model.addAttribute("dsKhachHang", khachHangService.getById(id));
        return "khachhang";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String insertNewKhachHang(@RequestBody KhachHang khachHang, Model model) throws InterruptedException {
        khachHangService.insertKhachHang(khachHang);
        model.addAttribute("dsKhachHang", khachHangService.getAllKhachHang());
        return "khachhang";
    }

    @DeleteMapping("/{khachHangId}")
    public String deleteKhachHang(@PathVariable("khachHangId") Long khachHangId, Model model) {
        var khachHang = khachHangService.getById(khachHangId);
        if (khachHang.isPresent())
            khachHangService.deleteKhachHang(khachHang.get());

        model.addAttribute("dsKhachHang", khachHangService.getAllKhachHang());
        return "khachhang";
    }

    @PutMapping("/{khachHangId}")
    public String updateKhachHang(@PathVariable("khachHangId") Long khachHangId,
                                  @RequestParam(required = false) String ten,
                                  @RequestParam(required = false) String email,
                                  @RequestParam(required = false) Integer dkm,
                                  Model model) {
        var khachHang = khachHangService.getById(khachHangId);
        if (khachHang.isPresent())
            khachHangService.updateKhachHang(khachHangId, ten, email, dkm);

        model.addAttribute("dsKhachHang", khachHangService.getAllKhachHang());
        return "khachhang";
    }
}
