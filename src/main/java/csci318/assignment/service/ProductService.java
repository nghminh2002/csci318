package csci318.assignment.service;

import csci318.assignment.model.Product;
import csci318.assignment.model.ProductDetail;

import java.util.List;

public interface ProductService {
    //product
    Product createProduct(Product newProduct);
    Product updateProduct(Long productId, Product updatedProduct);
    Product updateProductProductDetail(Long productId, Long productDetailId);
    Product getProduct(Long productId);
    List<Product> getAllProducts();

    //product details
    ProductDetail createProductDetail(ProductDetail newProductDetail);
    ProductDetail updateProductDetail(Long productDetailId, ProductDetail updatedProductDetail);
    ProductDetail getProductDetail(Long productDetailId);
    List<ProductDetail> getAllProductDetails();
}
