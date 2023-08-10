package csci318.assignment.controller;

import csci318.assignment.model.ProductDetail;
import csci318.assignment.model.Product;
import csci318.assignment.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product newProduct) {
        return productService.createProduct(newProduct);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}/detail/{detailId}")
    public Product updateProductProductDetail(@PathVariable Long id, @PathVariable Long detailId) {
        return productService.updateProductProductDetail(id, detailId);
    }

    @GetMapping("/{id}")
    Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @GetMapping()
    List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/detail")
    public ProductDetail createProductDetail(@RequestBody ProductDetail newProductDetail) {
        return productService.createProductDetail(newProductDetail);
    }

    @PutMapping("/detail/{id}")
    public ProductDetail updateProductDetail(@PathVariable Long id, @RequestBody ProductDetail detail) {
        return productService.updateProductDetail(id, detail);
    }

    @GetMapping("/detail/{id}")
    ProductDetail getProductDetail(@PathVariable Long id) {
        return productService.getProductDetail(id);
    }

    @GetMapping("/detail")
    List<ProductDetail> getAllProductDetails() {
        return productService.getAllProductDetails();
    }
}
