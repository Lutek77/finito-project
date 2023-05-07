package pl.coderslab.collapp.balance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class BalanceDTO {

    @Id
    private Long id;
    @NotBlank
    private double accountBalance;
    @NotBlank
    private short dpd;
    @NotBlank
    private LocalDate reportingDate;

}
