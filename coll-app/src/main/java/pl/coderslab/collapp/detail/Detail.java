package pl.coderslab.collapp.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "details")
public class Detail {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private int agreement_id;
        @Schema(description = "balance")
        private double accountBalance;
        @Schema(description = "day past due")
        private short dpd;
        @Schema(description = "date of balance")
        private LocalDate reportingDate;
}
