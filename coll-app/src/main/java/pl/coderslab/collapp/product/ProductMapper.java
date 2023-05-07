package pl.coderslab.collapp.product;

import org.mapstruct.Mapper;
import pl.coderslab.collapp.balance.Balance;
import pl.coderslab.collapp.client.Client;
import pl.coderslab.collapp.client.ClientDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // to DTO
    ProductDTO mapToDTO (Product product);
    List<ProductDTO> mapToDTO (List<Product> productList);

    // to Entity
    Product mapToEntity (ProductDTO productDTO);



}
