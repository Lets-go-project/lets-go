package controller.market;

import domain.market.Product;
import domain.member.User;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.MarketServiceImpl;

@Controller
@RequestMapping("/market")
@Log4j2
public class ProductController {
    private final MarketService marketService;

    @Autowired
    public ProductController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostConstruct
    public void init() {
        log.info("ProductController initialized.");
    }

    @GetMapping("/list")
    public String getAllProduct(Model model) {
        List<Product> productList = marketService.getAllProducts();
        model.addAttribute("productList", productList);

        log.info("ProductController: 상품 조회");

        return "market/Market";
    }

    // 물품 스크랩
    @PostMapping("/scrap")
    public String scrapProduct(@RequestParam("productId") int productId, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");

        if (currentUser == null) {
            return "redirect:/login";
        }

        marketService.scrapProduct(productId, currentUser.getUserId());

        return "redirect:/market";
    }
}
