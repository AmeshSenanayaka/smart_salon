package com.smart_salon.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart_salon.dto.SalonDTO;
import com.smart_salon.model.Salon;
import com.smart_salon.repository.SalonRepository;
import com.smart_salon.service.SalonService;
import com.smart_salon.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SalonServiceImpl implements SalonService {

    @Autowired
    SalonRepository salonRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public CommonResponse createSalon(SalonDTO salonDTO) {
        Salon salon =  objectMapper.convertValue(salonDTO, Salon.class);
        salon.setId(UUID.randomUUID().toString());

        salonRepository.save(salon);

        return null;
    }

}
