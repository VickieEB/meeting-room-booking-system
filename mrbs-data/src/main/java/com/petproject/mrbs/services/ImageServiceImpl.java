package com.petproject.mrbs.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public Byte[] processImageFile(MultipartFile file) {
        Byte[] byteObject = null;
        try {
            byteObject = new Byte[file.getBytes().length];
            int i=0;

            for (byte b : file.getBytes()) {
                byteObject[i++] = b;
            }
        } catch (IOException e) {
            log.error("Error Occured " + e.getMessage());
            e.printStackTrace();
        }

        return byteObject;
    }
}
