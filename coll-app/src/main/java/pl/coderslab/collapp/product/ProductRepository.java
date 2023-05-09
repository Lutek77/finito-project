package pl.coderslab.collapp.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository <Product, Long> {

/*    @Query("SELECT p FROM Product p JOIN p.detail where p.id =?1 " +
            "and p.detail.reportingDate = (\n" +
            "  SELECT min(p.detail.reportingDate)\n" +
            "  FROM p.detail where p.detail.agreement_id =?1\n" +
            ")")*/


/*    @Query(value = "select * from products p\n" +
            "         inner join details d  on p.id = d.agreement_id\n" +
            "         where p.id = ?1 and d.reporting_date = " +
            "(select min(reporting_date) from details where agreement_id = ?1)",
            nativeQuery = true)
    Optional <Product> findProductByIdAndDetail_ReportingDate(Long id);*/





}
