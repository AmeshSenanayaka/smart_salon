package com.smart_salon.service;

import com.smart_salon.dto.SalonDTO;
import com.smart_salon.util.CommonResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface SalonService {

    public CommonResponse createSalon(SalonDTO salonDTO);

    CommonResponse uploadProfilePic(MultipartFile file);
}
