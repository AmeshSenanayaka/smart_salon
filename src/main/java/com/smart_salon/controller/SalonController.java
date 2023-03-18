package com.smart_salon.controller;

import com.smart_salon.dto.SalonDTO;
import com.smart_salon.service.SalonService;
import com.smart_salon.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalonController {
    @Autowired
    SalonService salonService;

    public CommonResponse createSalon(@RequestBody SalonDTO salonDTO){

        return  salonService.createSalon(salonDTO);
    }


}
