package com.example.letsGo.controller.salesManager;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.product.Product;
import com.example.letsGo.domain.salesmanager.SalesManager;
import com.example.letsGo.repository.ProductRepository;
import com.example.letsGo.repository.SalesManagerRepository;
import com.example.letsGo.service.SalesManagerService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@Log4j2
@RequestMapping("/market/manager")
public class SalesManagerController {
    @Autowired
    private SalesManagerRepository salesManagerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @GetMapping("/")
    public String getSalesManagerPage(Model model) {
        return "salesManager/SalesManager";
    }

    @GetMapping("/add")
    public String getProductForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
         if (user != null) {
             model.addAttribute("user", user);
         }

        return "salesManager/RegisterProductForm";
    }

   @PostMapping("/add")
    public String addProduct(@RequestParam("productName") String productName,
                             @RequestParam("productPrice") int productPrice,
                             @RequestParam("productSellPrice") int productSellPrice,
                             @RequestParam("productDescription") String productDescription,
                             @RequestParam("files") MultipartFile[] files,
                             HttpSession session,
                             RedirectAttributes redirectAttributes) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/signin/signin";
        }

        try {
            // 파일 업로드 처리
            StringBuilder fileNames = new StringBuilder();
            for (MultipartFile file : files) {
                // 파일 이름 생성
                String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                // 파일 저장 경로 설정
                Path path = Paths.get(uploadDir + fileName);
                Files.write(path, file.getBytes());
                fileNames.append(fileName).append(" ");
            }
            log.info("업로드된 파일: " + fileNames);

            // Product 객체 생성 및 저장
            Product product = Product.builder()
                    .productName(productName)
                    .productPrice(productPrice)
                    .productSellPrice(productSellPrice)
                    .productDescription(productDescription)
                    .productImg(fileNames.toString()) // 파일 이름들을 문자열로 저장
                    .build();

            productRepository.save(product);

            redirectAttributes.addFlashAttribute("message", "상품 등록 성공");

            return "redirect:/market/manager";
        } catch (IOException e) {
            log.error("파일 업로드 실패: " + e.getMessage());
            redirectAttributes.addFlashAttribute("error", "파일 업로드 실패");
            return "redirect:/market/manager"; // 실패 시 관리자 페이지로 리다이렉트
        }
   }
}