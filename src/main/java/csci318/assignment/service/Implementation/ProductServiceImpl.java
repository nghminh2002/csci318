package csci318.assignment.service.Implementation;

import csci318.assignment.model.Product;
import csci318.assignment.model.ProductDetail;
import csci318.assignment.repository.ProductDetailRepository;
import csci318.assignment.repository.ProductRepository;
import csci318.assignment.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductDetailRepository productDetailRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductDetailRepository productDetailRepository) {
        this.productRepository = productRepository;
        this.productDetailRepository = productDetailRepository;
    }

    @Override
    public Product createProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(Long productId, Product updatedProduct) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(RuntimeException::new);

        if (updatedProduct.getProductCategory() != null) {
            existingProduct.setProductCategory(updatedProduct.getProductCategory());
        }

        if (updatedProduct.getName() != null) {
            existingProduct.setName(updatedProduct.getName());
        }

        if (updatedProduct.getPrice() != null) {
            existingProduct.setPrice(updatedProduct.getPrice());
        }
        return productRepository.save(existingProduct);
    }

    @Override
    public Product updateProductProductDetail(Long productId, Long productDetailId) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(RuntimeException::new);
        ProductDetail existingProductDetail = productDetailRepository.findById(productDetailId)
                .orElseThrow(RuntimeException::new);
        existingProduct.setProductDetail(existingProductDetail);
        return productRepository.save(existingProduct);
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductDetail createProductDetail(ProductDetail newProductDetail) {
        return productDetailRepository.save(newProductDetail);
    }

    @Override
    public ProductDetail updateProductDetail(Long productDetailId, ProductDetail updatedProductDetail) {
        ProductDetail existingProductDetail = productDetailRepository.findById(productDetailId)
                .orElseThrow(RuntimeException::new);
        if (updatedProductDetail.getDescription() != null) {
            existingProductDetail.setDescription(updatedProductDetail.getDescription());
        }

        if (updatedProductDetail.getComment() != null) {
            existingProductDetail.setComment(updatedProductDetail.getComment());
        }

        return productDetailRepository.save(existingProductDetail);
    }

    @Override
    public ProductDetail getProductDetail(Long productDetailId) {
        return productDetailRepository.findById(productDetailId)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<ProductDetail> getAllProductDetails() {
        return productDetailRepository.findAll();
    }
}
