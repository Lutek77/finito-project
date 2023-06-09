package pl.coderslab.collapp.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.collapp.product.Product;

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
        @Schema(description = "balance")
        private double accountBalance;
        @Schema(description = "day past due")
        private short dpd;
        @Schema(description = "date of balance")
        private LocalDate reportingDate;

        // relations
        // with product
        @ManyToOne
        private Product product;
}
