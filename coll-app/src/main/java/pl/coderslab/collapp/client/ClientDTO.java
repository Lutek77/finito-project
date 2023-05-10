package pl.coderslab.collapp.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.coderslab.collapp.product.ProductDTO;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
//@JsonIgnoreProperties({"productDTOList"})
@JsonPropertyOrder({"id", "firstName", "lastName", "pesel", "phoneNumber",
        "address", "email", "phone number", "productList"})
public class ClientDTO {


    @JsonProperty("Client's ID")
    @Id
    private Long id;

    @Schema(description = "name")
    private String firstName;
    @Schema(description = "surname")
    private String lastName;
    @Schema(description = "personal identity number")

    private String pesel;
    @Schema(description = "address")
    private String address;
    @Schema(description = "email")
    private String email;
    @Schema(description = "phone number")
    private int phoneNumber;

    private List<ProductDTO> productList;



}
