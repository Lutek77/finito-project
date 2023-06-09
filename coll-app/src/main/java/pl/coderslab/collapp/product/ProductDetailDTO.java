package pl.coderslab.collapp.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.collapp.detail.DetailDTO;
import pl.coderslab.collapp.type.TypeDTO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({"id", "type", "agreement", "iban", "detail"})
public class ProductDetailDTO {

    @JsonProperty("product's ID")
    private Long id;
    @Schema(description = "number of agreement", example = "CC-51301234")
    @JsonProperty("agreement's number")
    private String agreement;

    @Schema(description = "account number", example = "29105010501111222251301234")
    private String iban;

    private TypeDTO type;


    // Test
    private DetailDTO detail;

}
