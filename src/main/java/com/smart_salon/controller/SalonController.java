package com.smart_salon.controller;

import com.smart_salon.dto.SalonDTO;
import com.smart_salon.service.SalonService;
import com.smart_salon.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("salon")
public class SalonController {

    @Autowired
    SalonService salonService;

    @PostMapping("/")
    public CommonResponse createSalon(@RequestBody SalonDTO salonDTO){

        return  salonService.createSalon(salonDTO);
    }

    @PostMapping("/upload")
    public CommonResponse uploadFile(@RequestParam(value = "file") MultipartFile file) {
        return  salonService.uploadProfilePic(file);
    }


}
