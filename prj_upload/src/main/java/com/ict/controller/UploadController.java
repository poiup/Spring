package com.ict.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {
	
	@GetMapping("uploadForm")
	public void uploadForm() {
		System.out.println("upload form");
	}
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		
			String uploadFolder = "C:\\upload_fata\\temp";
		
			for(MultipartFile multipartFile: uploadFile) {
				System.out.println("---------------------------------");
				System.out.println("Upload File name" + multipartFile.getOriginalFilename());
				System.out.println("Upload File size" + multipartFile.getSize());
				
				File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
				
				try {
					multipartFile.transferTo(saveFile);
				} catch (Exception e) {
					log.error(e.getMessage());
				}			
			}// end for
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("upload ajax");
	}
	@PostMapping("/uploadAjaxAction")
	public void uploadAjaxPost(MultipartFile[] uploadFile) {
		log.info("ajax post update!");
		
		String uploadFolder = "C:\\upload_data\\temp";
		
		for(MultipartFile multipartFile: uploadFile) {
			System.out.println("---------------------------------");
			System.out.println("Upload File name" + multipartFile.getOriginalFilename());
			System.out.println("Upload File size" + multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}			
		}// end for
	}
}
