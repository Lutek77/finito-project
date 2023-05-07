package pl.coderslab.collapp.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository <Product, Long> {

    @Query("SELECT p FROM Product p JOIN p.detail where p.id =?1 " +
            "and p.detail.reportingDate = (\n" +
            "  SELECT max(p.detail.reportingDate)\n" +
            "  FROM p.detail\n" +
            ")")
    Optional <Product> findByAgreementAndDetail_ReportingDate(Long id);


}
