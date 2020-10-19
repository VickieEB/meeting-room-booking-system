package com.petproject.mrbs.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Byte[] processImageFile(MultipartFile file);
}
