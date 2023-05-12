package pl.coderslab.collapp.product;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.coderslab.collapp.exception.IdMismatchException;
import pl.coderslab.collapp.exception.ResourceNotFoundException;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductDetailMapper productDetailMapper;


    public ProductService(ProductRepository productRepository, ProductMapper productMapper, ProductDetailMapper productDetailMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;

        this.productDetailMapper = productDetailMapper;
    }

    // CREATE
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productMapper.mapToEntity(productDTO);
        Assert.isNull(product.getId(), "id must be null");
        productRepository.save(product);
        return productMapper.mapToDTO(product);
    }
    // READ

    public ProductDTO getProductByIdWithDetails(Long id) {
        return productMapper.mapToDTO(
                productRepository.findById(id)
                        .orElse(null));
    }


    // UPDATE
    public ProductDTO updateMovie(Long id, ProductDTO productDTO) {
        Assert.notNull(productDTO.getId(), "cannot be empty");
        if (!productDTO.getId().equals(id)) {
            throw new IdMismatchException("Id's mismatch");
        }
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product doesn't exist");
        }
        Product product = productMapper.mapToEntity(productDTO);
        productRepository.save(product);
        return productMapper.mapToDTO(product);
    }

    // DELETE
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    // Test
    public ProductDetailDTO getByIdWithFirstBalance(Long id) {
        return productDetailMapper.mapToDTO(
                productRepository.findProductByIdWithFirstDetails(id));
    }

}
