package pl.coderslab.collapp.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.collapp.product.Product;

import java.util.List;

public interface ClientRepository extends JpaRepository <Client, Long> {

    // my del
    @Modifying
    @Transactional
    // @Query("delete Client c where c.id = ?1")
    @Query(value = "delete from clients where id = ?1", nativeQuery = true)
    int deleteClientsById (Long id);


    // for tests
    Client findFirstByFirstName(String name);





}
