package com.smart_salon.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart_salon.dto.SalonDTO;
import com.smart_salon.model.Salon;
import com.smart_salon.repository.SalonRepository;
import com.smart_salon.service.SalonService;
import com.smart_salon.util.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class SalonServiceImpl implements SalonService {

    @Autowired
    SalonRepository salonRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private AmazonS3 s3Client;

    @Value("${application.bucket.name}")
    private String bucketName;

    @Override
    public CommonResponse createSalon(SalonDTO salonDTO) {
        Salon salon =  objectMapper.convertValue(salonDTO, Salon.class);
        salon.setId(UUID.randomUUID().toString());

        salonRepository.save(salon);

        return null;
    }

    @Override
    public CommonResponse uploadProfilePic(MultipartFile file) {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        //fileObj.delete();
        return null;
    }

    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }

}
