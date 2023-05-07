package pl.coderslab.collapp.type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class TypeDTO {
    private Long id;
    @Schema(description = "product type",example = "CC")
    private String productType;
    @Schema(description = "product name", example = "credit card")
    @JsonValue // representation of object in Json
    private String productName;
    @Schema(description = "add date", example = "2023-05-01")
    private LocalDate creationDate;


}
