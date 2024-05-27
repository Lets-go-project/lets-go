package controller.market;

import domain.market.Product;
import domain.member.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/market")
public class ProductController {
    @Autowired
    private final MarketService marketService;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(MarketService marketService) {
        this.marketService = marketService;
    }

//    @PostConstruct
//    public void init() {
//        logger.info("ProductController initialized.");
//    }

    // 상품 전체 조회
//    @GetMapping("/list")
//    public ModelAndView getAllProduct(ModelAndView mv) {
//        List<Product> product = marketService.getAllProducts();
//
//        mv.setViewName("market/Market");
//        return mv;
//    }
    @GetMapping("/list")
    public String getAllProduct(Model model) {
        List<Product> productList = marketService.getAllProducts();
        model.addAttribute("productList", productList);

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
