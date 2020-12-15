package com.kimhs.apis.route;

import com.kimhs.apis.model.Product;
import com.kimhs.apis.model.User;
import com.kimhs.apis.service.ProductService;
import com.kimhs.apis.vo.ProductRegisterVO;
import com.kimhs.apis.vo.UserRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRoute {
    private final ProductService productService;

    @Autowired
    public ProductRoute(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{product_id}")
    @ResponseBody
    public Product getProduct(@PathVariable(value="product_id") String productId) throws Exception {
        return this.productService.find(Integer.parseInt(productId));
    }

    @PostMapping("")
    public void createProduct(ProductRegisterVO product) {
        this.productService.createProduct(product);
    }

    @GetMapping("/initialize")
    public void initializeProducts() {
        this.productService.initializeProducts();
    }

    @DeleteMapping("/{product_id}")
    public void deleteProduct(@PathVariable(value = "product_id") String productId) {
        this.productService.deleteProduct(Integer.parseInt(productId));
    }
}
