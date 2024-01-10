//: webstart.controller.ProductController.java


package webstart.controller;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import webstart.domain.model.Product;
import webstart.service.ProductService;

import java.util.List;


@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
class ProductController {

    private final ProductService productService;

    @GetMapping
    public String viewAllProducts(final Model model) {

        final List<Product> products = this.productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

    @PostMapping
    public String addProduct(
            @RequestParam @NonNull final String name,
            @RequestParam final long price,
            Model model) {

        this.productService.addProduct(Product.of(name, price));
        model.addAttribute("products", this.productService.findAll());

        return "products.html";
    }

//    @PostMapping
//    public String addProduct(Product product, Model model) {
//
//        this.productService.addProduct(product);
//        model.addAttribute("products", this.productService.findAll());
//
//        return "products.html";
//    }

}///:~