package pl.coderslab.collapp.product;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDetailMapper {
    ProductDetailDTO mapToDTO (Product product);
    Product mapToEntity (ProductDetailDTO productDetailDTO);
}
