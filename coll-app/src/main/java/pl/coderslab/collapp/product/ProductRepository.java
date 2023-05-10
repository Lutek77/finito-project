package pl.coderslab.collapp.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

/*    @Query(value = "select * from products p\n" +
            "         inner join details d  on p.id = d.product_id\n" +
            "         where p.id = ?1 and d.reporting_date = " +
            "(select min(reporting_date) from details where product_id = ?1)",
            nativeQuery = true)*/


/*    @Query(
            "Select p from Product p Join fetch p.detail where p.id =?1 " +
            "and p.detail.reportingDate = ( SELECT min(p.detail.reportingDate) " +
            "FROM p.detail where p.detail.product =?1 ) "
            )
    Product findAllByIdAndDetail_AccountBalance(Long id);*/


}
