package com.shoppingmall.none.admin.adminProduct.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;
import com.shoppingmall.none.admin.adminProduct.dao.AdminProductDao;
import com.shoppingmall.none.admin.adminProduct.service.AdminProductService;
import com.shoppingmall.none.admin.adminProduct.vo.AdminFileVo;
import com.shoppingmall.none.admin.adminProduct.vo.AdminProductVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminProductController {

	@Autowired
	private AdminProductService adminProductService;
	private AdminProductVo adminProductVo;
	private AdminProductDao adminProductDao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 상품관리 페이지 들어옴
	@GetMapping("/adminProduct")
	public String adminUser(HttpSession session) {
		System.out.println("상품관리 페이지 들어옴");
		String userId = (String) session.getAttribute("userId");

		if (userId != null && userId.equals("admin")) {
			return "admin/product/adminProduct";
		} else {
			System.out.println("로그인 후 이용이 가능합니다.");
			return "redirect:/adminLogin";
		}
	}

	// 상품 등록하는 팝업 들어옴
	@GetMapping(value = "/adminProductRegi")
	public String adminProductRegi(HttpSession session) {
		System.out.println("상품관리 페이지 들어옴");
		String userId = (String) session.getAttribute("userId");

		if (userId != null && userId.equals("admin")) {
			return "admin/product/adminProductRegi";
		} else {
			System.out.println("로그인 후 이용이 가능합니다.");
			return "redirect:/adminLogin";
		}
	}

	// 내용 및 이미지 등록하는 메소드
	@PostMapping(value = "/adminProductInfo")
	@ResponseBody
	public String adminProductInfo(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("productName") String productName, @RequestParam("productPrice") int productPrice,
			@RequestParam("productQuantity") int productQuantity, @RequestParam("productContent") String productContent,
			@RequestParam("fileName") String fileName, @RequestParam("filePath") String filePath,
			MultipartHttpServletRequest multiFile, AdminProductVo adminProductVo, AdminFileVo adminFileVo) throws Exception {
		// 받아온 데이터를 처리하는 로직을 구현합니다.
		// 이 예제에서는 단순히 받은 데이터를 로그에 출력합니다.

		String userId = (String) session.getAttribute("userId");

		if (userId != null && userId.equals("admin")) {

			System.out.println("상품명: " + productName);
			System.out.println("상품가격: " + productPrice);
			System.out.println("상품수량: " + productQuantity);
			System.out.println("상품내용: " + productContent);
			System.out.println("파일이름: " + fileName);
			System.out.println("파일경로: " + filePath);
			adminProductVo.setProductName(productName);
			adminProductVo.setProductPrice(productPrice);
			adminProductVo.setProductQuantity(productQuantity);
			adminProductVo.setProductContent(productContent);

			adminFileVo.setFileName(fileName);
			adminFileVo.setFilePath(filePath);
			System.out.println("adminFileVo getName " + adminFileVo.getFileName());
			System.out.println("adminFileVo filePath " + adminFileVo.getFilePath());

			System.out.println("adminProductVo. name : " + adminProductVo.getProductName());
			System.out.println("adminProductVo. productPrice : " + adminProductVo.getProductPrice());
			int productResult = adminProductService.adminProductInfo(adminProductVo);
			int fileResult = adminProductService.adminFileInfo(adminFileVo);
//			System.out.println("이미지 : " + productImage);
//			AdminProductController.adminProductImg(request, response, multiFile);
//			System.out.println("request : " + request);
//			System.out.println("response : " + response);
//			System.out.println("multiFile : " + multiFile);

			return "admin/product/adminProductRegi";
		} else {
			System.out.println("로그인 후 이용이 가능합니다.");
			return "redirect:/adminLogin";
		}
	}

	@PostMapping(value = "/adminProductImg")
	@ResponseBody
	public static void adminProductImg(HttpServletRequest request, HttpServletResponse response,
			MultipartHttpServletRequest multiFile) throws IOException {
		System.out.println("IMG 들어옴");
		// Json 객체 생성
		JsonObject json = new JsonObject();
		// Json 객체를 출력하기 위해 PrintWriter 생성
		PrintWriter printWriter = null;
		OutputStream out = null;
		// 파일을 가져오기 위해 MultipartHttpServletRequest 의 getFile 메서드 사용
		MultipartFile file = multiFile.getFile("upload");
		// 파일이 비어있지 않고(비어 있다면 null 반환)
		if (file != null) {
			// 파일 사이즈가 0보다 크고, 파일이름이 공백이 아닐때
			if (file.getSize() > 0 && StringUtils.isNotBlank(file.getName())) {
				if (file.getContentType().toLowerCase().startsWith("image/")) {

					try {
						// 파일 이름 설정
						String originalFileName = file.getOriginalFilename();
						String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
						String fileName = UUID.randomUUID().toString() + fileExtension;

						// 바이트 타입설정
						byte[] bytes;
						// 파일을 바이트 타입으로 변경
						bytes = file.getBytes();
						// 파일이 실제로 저장되는 경로
						String uploadPath = request.getServletContext().getRealPath("/resources/ckUpload/");
						// 저장되는 파일에 경로 설정
						File uploadFile = new File(uploadPath);
						if (!uploadFile.exists()) {
							uploadFile.mkdirs();
						}
						// 업로드 경로 + 파일이름을 줘서 데이터를 서버에 전송
						uploadPath = uploadPath + "/" + fileName;
						out = new FileOutputStream(new File(uploadPath));
						out.write(bytes);

						// 클라이언트에 이벤트 추가
						printWriter = response.getWriter();
						response.setContentType("text/html");

						// 파일이 연결되는 Url 주소 설정
						String fileUrl = request.getContextPath() + "/resources/ckUpload/" + fileName;

						// 생성된 json 객체를 이용해 파일 업로드 + 이름 + 주소를 CkEditor에 전송
						json.addProperty("uploaded", 1);
						json.addProperty("fileName", fileName);
						json.addProperty("url", fileUrl);
						printWriter.println(json);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
						if (printWriter != null) {
							printWriter.close();
						}
					}
				}
			}
		}
	}

}