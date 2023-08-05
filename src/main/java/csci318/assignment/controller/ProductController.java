package csci318.assignment.controller;

import csci318.assignment.model.ProductDetail;
import csci318.assignment.model.Product;
import csci318.assignment.repository.ProductDetailRepository;
import csci318.assignment.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;

    public ProductController(ProductRepository productRepository, ProductDetailRepository productDetailRepository) {
        this.productRepository = productRepository;
        this.productDetailRepository = productDetailRepository;
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        if (product.getProductCategory() != null) {
            existingProduct.setProductCategory(product.getProductCategory());
        }

        if (product.getName() != null) {
            existingProduct.setName(product.getName());
        }

        if (product.getPrice() != null) {
            existingProduct.setPrice(product.getPrice());
        }
        return productRepository.save(existingProduct);
    }

    @PutMapping("/product/{id}/detail/{detailId}")
    public Product updateProductProductDetail(@PathVariable Long id, @PathVariable Long detailId) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        ProductDetail existingProductDetail = productDetailRepository.findById(detailId)
                .orElseThrow(RuntimeException::new);
        existingProduct.setProductDetail(existingProductDetail);
        return productRepository.save(existingProduct);
    }

    @GetMapping("/product/{id}")
    Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @GetMapping("/product")
    List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/product/detail")
    public ProductDetail createProductDetail(@RequestBody ProductDetail newProductDetail) {
        return productDetailRepository.save(newProductDetail);
    }

    @PutMapping("/product/detail/{id}")
    public ProductDetail updateProductDetail(@PathVariable Long id, @RequestBody ProductDetail detail) {
        ProductDetail existingProductDetail = productDetailRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        if (detail.getDescription() != null) {
            existingProductDetail.setDescription(detail.getDescription());
        }

        if (detail.getComment() != null) {
            existingProductDetail.setComment(detail.getComment());
        }

        return productDetailRepository.save(existingProductDetail);
    }

    @GetMapping("/product/detail/{id}")
    ProductDetail getProductDetail(@PathVariable Long id) {
        return productDetailRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @GetMapping("/product/detail")
    List<ProductDetail> getAllProductDetails() {
        return productDetailRepository.findAll();
    }
}
