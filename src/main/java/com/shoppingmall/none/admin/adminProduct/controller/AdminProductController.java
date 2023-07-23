package com.shoppingmall.none.admin.adminProduct.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shoppingmall.none.admin.adminProduct.dao.AdminProductDao;
import com.shoppingmall.none.admin.adminProduct.service.AdminProductService;
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
	public String adminProductInfo(HttpSession session, HttpServletRequest req, HttpServletResponse res,
			@RequestParam("productName") String productName, @RequestParam("productPrice") String productPrice,
			@RequestParam("productQuantity") String productQuantity, @RequestParam("productContent") String productContent,
			@RequestParam("file") MultipartFile productImage) throws Exception {
		// 받아온 데이터를 처리하는 로직을 구현합니다.
		// 이 예제에서는 단순히 받은 데이터를 로그에 출력합니다.

		String userId = (String) session.getAttribute("userId");

		if (userId != null && userId.equals("admin")) {

			System.out.println("상품명: " + productName);
			System.out.println("상품가격: " + productPrice);
			System.out.println("상품수량: " + productQuantity);
			System.out.println("상품내용: " + productContent);
			System.out.println("이미지 : " + productImage);

			/*
			 * logger.info("ckUpload 진입 =========================================1");
			 * 
			 * // 랜덤 문자 생성 UUID uid = UUID.randomUUID();
			 * 
			 * OutputStream out = null; PrintWriter printWriter = null;
			 * 
			 * // 인코딩 res.setCharacterEncoding("utf-8");
			 * res.setContentType("text/html;charset=utf-8");
			 * 
			 * try {
			 * 
			 * String fileName = file.getOriginalFilename(); // 파일 이름 가져오기 byte[] bytes =
			 * file.getBytes();
			 * 
			 * // 업로드 경로 String ckUploadPath = uploadPath + File.separator + "ckUpload" +
			 * File.separator + uid + "_" + fileName;
			 * 
			 * out = new FileOutputStream(new File(ckUploadPath)); out.write(bytes);
			 * out.flush(); // out에 저장된 데이터를 전송하고 초기화
			 * 
			 * String callback = req.getParameter("CKEditorFuncNum"); printWriter =
			 * res.getWriter(); String fileUrl = "/ckUpload/" + uid + "_" + fileName; //
			 * 작성화면 // String fileUrl = "/ckUpload/" + uid + "&fileName=" + fileName; //
			 * 작성화면
			 * 
			 * // 업로드시 메시지 출력 printWriter.println("<script type='text/javascript'>" +
			 * "window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + fileUrl +
			 * "','이미지를 업로드하였습니다.')" + "</script>");
			 * 
			 * printWriter.flush();
			 * 
			 * int result = adminProductService.adminProductInfo(adminProductVo);
			 * 
			 * } catch (IOException e) { e.printStackTrace(); } finally { try { if (out !=
			 * null) { out.close(); } if (printWriter != null) { printWriter.close(); } }
			 * catch (IOException e) { e.printStackTrace(); } }
			 */

			return "admin/product/adminProductRegi";
		} else {
			System.out.println("로그인 후 이용이 가능합니다.");
			return "redirect:/adminLogin";
		}
	}

	@PostMapping(value = "/adminProductImg")
	@ResponseBody
	public String adminProductImg(@RequestParam("file") MultipartFile file) {
		System.out.println("Uploaded file name: " + file.getOriginalFilename());
		return "File upload success!";
	}

}