package com.fmv.ims.controllers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RestController
public class FileController {
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) {
        logger.info(String.format("File name '%s' uploaded successfully.", file.getOriginalFilename()));
        String fileName = file.getOriginalFilename();
        try {
          file.transferTo( new File(fileName));
        } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } 
        return ResponseEntity.status(HttpStatus.OK).body("D:\\FirstMoove\\profile-pictures\\"+fileName);
    }

    @PostMapping("/download")
    public ResponseEntity downloadFile1(@RequestParam String fileName)  {
        
        File file = new File(fileName);
        InputStreamResource resource;
		try {
			resource = new InputStreamResource(new FileInputStream(file));
			return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .contentLength(file.length()) 
	                .body(resource);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                .contentLength(file.length()) 
	                .body("No file found");
		}

        
    }
}
