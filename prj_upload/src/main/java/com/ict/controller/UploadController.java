package com.ict.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ict.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Log4j
public class UploadController {
	
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			
			return contentType.startsWith("image");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		
		Date date = new Date();
		
		String str = sdf.format(date);
		
		return str.replace("-", File.separator);
	}
	@GetMapping("uploadForm")
	public void uploadForm() {
		System.out.println("upload form");
	}
	@PostMapping(value="/uploadFormAction",
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadFormPost(MultipartFile[] uploadFile, Model model) {
		
			// AttachFileDTO는 파일 한개의 정보를 저장합니다
			// 현재 파일 업로드는 여러 파일을 동시에 업로드하므로 List<AttachFileDTO>를 받도록 처리합니다.
			List<AttachFileDTO> list = new ArrayList<>();
			String uploadFolder = "C:\\upload_data\\temp";
			
			String uploadFolderPath = getFolder();
			
			File uploadPath = new File(uploadFolder, uploadFolderPath);
			if(uploadPath.exists() == false) {
				uploadPath.mkdirs();
			}
		
			for(MultipartFile multipartFile: uploadFile) {
				System.out.println("---------------------------------");
				System.out.println("Upload File name" + multipartFile.getOriginalFilename());
				System.out.println("Upload File size" + multipartFile.getSize());
				
				AttachFileDTO attachDTO = new AttachFileDTO();
				
				String uploadFileName = multipartFile.getOriginalFilename();
				
				//uuid 발급
				uploadFileName = uploadFileName.substring(
												uploadFileName.lastIndexOf("\\")+1);
				log.info("only file name: " + uploadFileName);
				attachDTO.setFileName(uploadFileName);

				UUID uuid = UUID.randomUUID();
				
				try {
					File saveFile = new File(uploadFolder, uploadFileName);
					multipartFile.transferTo(saveFile);
					
					attachDTO.setUuid(uuid.toString());
					attachDTO.setUploadPath(uploadFolderPath);
					
					if(checkImageType(saveFile)) {
						attachDTO.setImage(true);
						
						FileOutputStream thumnail = new FileOutputStream(
													new File(uploadPath, "s_" + uploadFileName));
						Thumbnailator.createThumbnail(
									multipartFile.getInputStream(), thumnail, 100, 100);
						
						thumnail.close();
					}
					list.add(attachDTO);
				} catch (Exception e) {
					log.error(e.getMessage());
				}			
			}// end for
			return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("upload ajax");
	}
	@PostMapping(value = "/uploadAjaxAction",
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		log.info("ajax post update!");
		List<AttachFileDTO> list = new ArrayList<>();
		String uploadFolder = "C:\\upload_data\\temp";
		
		String uploadFolderPath = getFolder();
		
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		log.info("uploadPath: " + uploadPath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		for(MultipartFile multipartFile: uploadFile) {
			System.out.println("---------------------------------");
			System.out.println("Upload File name" + multipartFile.getOriginalFilename());
			System.out.println("Upload File size" + multipartFile.getSize());
			
			AttachFileDTO attachDTO = new AttachFileDTO();
			
			String uploadFileName = multipartFile.getOriginalFilename();
			
			//uuid 발급
			uploadFileName = uploadFileName.substring(
											uploadFileName.lastIndexOf("\\")+1);
			log.info("only file name: " + uploadFileName);
			attachDTO.setFileName(uploadFileName);

			UUID uuid = UUID.randomUUID();
			
			try {
				File saveFile = new File(uploadFolder, uploadFileName);
				multipartFile.transferTo(saveFile);
				
				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);
				
				if(checkImageType(saveFile)) {
					attachDTO.setImage(true);
					
					FileOutputStream thumnail = new FileOutputStream(
												new File(uploadPath, "s_" + uploadFileName));
					Thumbnailator.createThumbnail(
								multipartFile.getInputStream(), thumnail, 100, 100);
					
					thumnail.close();
				}
				list.add(attachDTO);
			} catch (Exception e) {
				log.error(e.getMessage());
			}			
		}// end for
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName){
		log.info("fileName : " + fileName);
		
		File file = new File("C:\\upload_data\\temp\\" + fileName);
		
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-type", Files.probeContentType(file.toPath()));
			
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@GetMapping(value="/download",
				produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(String fileName){
		log.info("download file : " + fileName);
		Resource resource = new FileSystemResource("C:\\upload_data\\temp\\" + fileName);
		
		log.info("resource : " +resource);
		
		String resourceName = resource.getFilename();
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			headers.add("Content-Disposition", "attachment; filename="+ new String(resourceName.getBytes("UTF-8"), "ISO-8859-1"));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
	}
	
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type){
		log.info("deleteFile : " + fileName);
		
		File file = null;
		
		try {
			file = new File("c:\\upload_data\\temp\\" + URLDecoder.decode(fileName, "UTF-8"));
			
			file.delete();
			if(type.equals("image")) {
				String largeFileName = file.getAbsolutePath().replace("s_","");
				log.info("largeFileName : " + largeFileName);
				file = new File(largeFileName);
				file.delete();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
}
