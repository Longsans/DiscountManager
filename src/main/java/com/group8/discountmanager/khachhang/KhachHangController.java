package com.group8.discountmanager.khachhang;

import com.group8.discountmanager._fortests.TestThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

@Controller
@RequestMapping(path = "/khachhang")
public class KhachHangController {

    private final KhachHangService khachHangService;

    @Autowired
    public KhachHangController(KhachHangService khachHangService) {
        this.khachHangService = khachHangService;
    }

    @GetMapping(path = {"/", ""})
    public String allKhachHang(Model model) throws InterruptedException {
        model.addAttribute("dsKhachHang", khachHangService.getAllKhachHang());
        return "khachhang";
    }

    @GetMapping(path = "/{khachHangId}")
    public String getKhachHangById(@PathVariable("khachHangId") Long id, Model model) throws InterruptedException {
        var khachHang = khachHangService.getById(id);
        if (khachHang != null)
            model.addAttribute("dsKhachHang", List.of(khachHang));
        else
            model.addAttribute("dsKhachHang", Collections.emptyList());
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
    public String deleteKhachHang(@PathVariable("khachHangId") Long khachHangId, Model model) throws InterruptedException {
        var khachHang = khachHangService.getById(khachHangId);
        if (khachHang != null)
            khachHangService.deleteKhachHang(khachHang);

        model.addAttribute("dsKhachHang", khachHangService.getAllKhachHang());
        return "khachhang";
    }

    @PutMapping("/{khachHangId}")
    public String updateKhachHang(@PathVariable("khachHangId") Long khachHangId,
                                  @RequestParam(required = false) String ten,
                                  @RequestParam(required = false) String email,
                                  @RequestParam(required = false) Integer dkm,
                                  Model model) throws InterruptedException {
        var khachHang = khachHangService.getById(khachHangId);
        if (khachHang != null)
            khachHangService.updateKhachHang(khachHangId, ten, email, dkm);

        model.addAttribute("dsKhachHang", List.of(khachHangService.getById(khachHangId)));
        return "khachhang";
    }

    @RequestMapping("/updatethendelete")
    public String createThenDeleteWhileUpdating(@RequestParam(name = "khachhangid") Long khachHangId, Model model) {
        var resultWrapper = new Object() {String result = "";};
        ExecutorService threadExecutor = Executors.newFixedThreadPool(2);

        TestThread deleteThread = new TestThread(() -> {
            var khachHang = khachHangService.getById(khachHangId);
            if (khachHang != null) {
                try {
                    khachHangService.deleteKhachHang(khachHang);
                } catch (Exception ex) {
                    model.addAttribute("error", ex);
                    model.addAttribute("message", ex.getMessage());
                    resultWrapper.result = "error";
                    return;
                }
            }

            model.addAttribute("dsKhachHang", khachHangService.getAllKhachHang());
            resultWrapper.result = "khachhang";
        }, () -> {
            System.out.println("----------deleteKhachHang finished!");
        });

        TestThread updateThread = new TestThread(() -> {
            var khachHang = khachHangService.getById(khachHangId);
            if (khachHang != null) {
                try {
                    khachHangService.updateKhachHang(khachHangId,
                            "boomer", "family@1972.com", 250);
                }
                catch (Exception ex) {
                    model.addAttribute("error", ex);
                    model.addAttribute("message", ex.getMessage());
                    resultWrapper.result = "error";
                    return;
                }
            }
            model.addAttribute("dsKhachHang", List.of(khachHangService.getById(khachHangId)));
            resultWrapper.result =  "khachhang";
        }, () -> {
            System.out.println("----------updateKhachHang finished!");
        });

        var khachHang = new KhachHang();
        khachHang.setId((long)0);
        khachHang.setTen("chad");
        khachHang.setEmail("thundercok@slayer.com");
        khachHang.setDiemKhuyenMai(5000);
        khachHangService.insertKhachHang(khachHang);

        threadExecutor.execute(updateThread);
        threadExecutor.execute(deleteThread);
        threadExecutor.shutdown();

        try {
            threadExecutor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultWrapper.result;
    }
}
