package pl.coderslab.collapp.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.collapp.balance.BalanceDTO;
import pl.coderslab.collapp.client.ClientDTO;
import pl.coderslab.collapp.type.TypeDTO;

@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({"client", "id", "agreement", "typeDTO", "iban", "balanceDTO"})
public class ProductDTO {
    @JsonProperty("Product's ID")
    private Long id;
    @Schema(description = "number of agreement", example = "CC-51301234")
    @JsonProperty("agreement's number")
    private String agreement;

    @Schema(description = "account number", example = "29105010501111222251301234")
    private String iban;


    private ClientDTO client;
    private BalanceDTO balanceDTO;
    private TypeDTO typeDTO;




}
