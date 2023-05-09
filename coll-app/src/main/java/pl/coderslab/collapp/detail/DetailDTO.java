package pl.coderslab.collapp.detail;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class DetailDTO {
    @JsonIgnore
    @Id
    private Long id;
    @NotBlank
    @JsonProperty("account's balance") // name of field in Json
    private double accountBalance;

    @NotBlank
    @JsonProperty("days of payment's delay")
    private short dpd;
    @NotBlank
    @JsonProperty("balance's date")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate reportingDate;
}
