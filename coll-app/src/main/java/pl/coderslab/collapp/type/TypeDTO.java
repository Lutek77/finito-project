package pl.coderslab.collapp.type;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class TypeDTO {


    private Long id;
    @Schema(description = "product type",example = "CC")
    private int prodtype;

    @Schema(description = "product name", example = "credit card")
    private String productName;

    @Schema(description = "producy add date", example = "2023-05-01")
    private LocalDate creationDate;


}
