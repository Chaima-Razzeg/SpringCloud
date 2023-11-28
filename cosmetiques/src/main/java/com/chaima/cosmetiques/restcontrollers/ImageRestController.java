package com.chaima.cosmetiques.restcontrollers;
import com.chaima.cosmetiques.entities.Cosmetique;
import com.chaima.cosmetiques.entities.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.chaima.cosmetiques.service.CosmetiqueService;
import com.chaima.cosmetiques.service.ImageService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
    @Autowired
    ImageService imageService ;
    @Autowired
    CosmetiqueService cosmetiqueService;


    @RequestMapping(value = "/upload" , method = RequestMethod.POST)
    public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }
    @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
        return imageService.getImageDetails(id) ;
    }
    @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException
    {
        return imageService.getImage(id);
    }


    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable("id") Long id){
        imageService.deleteImage(id);
    }
    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
        return imageService.uplaodImage(file);
    }
    @PostMapping(value = "/uplaodImageCosm/{idCosm}" )
    public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
    @PathVariable("idCosm") Long idCosm)
   throws IOException {
    return imageService.uplaodImageCosm(file,idCosm);
    }
   @RequestMapping(value = "/getImagesCosm/{idCosm}" ,
    method = RequestMethod.GET)
    public List<Image> getImagesCosm(@PathVariable("idCosm") Long idCosm)
   throws IOException {
    return imageService.getImagesParCosm(idCosm);
    }
   @RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
   public void uploadImageFS(@RequestParam("image") MultipartFile
  file,@PathVariable("id") Long id) throws IOException {
   Cosmetique p = cosmetiqueService.getCosmetique(id);
   p.setImagePath(id+".jpg");

  Files.write(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath())
  , file.getBytes());
   cosmetiqueService.saveCosmetique(p);

   }
   @RequestMapping(value = "/loadfromFS/{id}" ,
   method = RequestMethod.GET,
   produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
   public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

   Cosmetique p = cosmetiqueService.getCosmetique(id);
   return
  Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
   }
}