package com.chaima.cosmetiques.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chaima.cosmetiques.entities.Image;

import java.io.IOException;
import java.util.List;

public interface ImageService {
	Image uplaodImage(MultipartFile file) throws IOException;
	 Image getImageDetails(Long id) throws IOException;
	 ResponseEntity<byte[]> getImage(Long id) throws IOException;
	 void deleteImage(Long id) ;
	 Image uplaodImageCosm(MultipartFile file,Long idProd) throws IOException;
	 List<Image> getImagesParCosm(Long prodId);

}