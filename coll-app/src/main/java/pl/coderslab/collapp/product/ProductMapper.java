package pl.coderslab.collapp.product;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // to DTO
    ProductDTO mapToDTO (Product product);
    List<ProductDTO> mapToDTO (List<Product> productList);

    // to Entity
    Product mapToEntity (ProductDTO productDTO);





}
