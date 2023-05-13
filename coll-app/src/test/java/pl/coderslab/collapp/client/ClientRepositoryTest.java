package pl.coderslab.collapp.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import pl.coderslab.collapp.product.Product;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClientRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Autowired
    ClientRepository clientRepository;

    ///@Sql(scripts = "classpath:data.sql")

    @Test
    void give_client_name_should_return_this_client () {
        // given - find
        List<Product> productList = new ArrayList<>();
        Client client = new Client(100L, "Ala", "Kot",
                "79010112345", "Otwock", "ala@wp.pl", 609100890, productList );
        testEntityManager.persist(client);
        // when - find in database
        Client result = (Client) clientRepository.findFirstByFirstName("Ala");
        // then - equals
        assertThat(result).isNotNull();
        assertEquals(client.getFirstName(), result.getFirstName());

    }

    @Test
    void find_with_the_same_client_name () {
        // given - find
        List<Product> productList = new ArrayList<>();
        Client clientOne = new Client(20L, "Ala", "Kot",
                "79010112345", "Otwock", "ala@wp.pl", 609100890, productList );
        testEntityManager.persist(clientOne);
        Client clientTwo = new Client(21L, "Ala", "Pies",
                "89010112345", "Kalisz", "alap@wp.pl", 809100890, productList );
        testEntityManager.persist(clientTwo);
        Client clientThree = new Client(22L, "Edmund", "Ryś",
                "69010112345", "Genewa", "er@wp.pl", 509100890, productList );
        testEntityManager.persist(clientThree);
        // when - find in database
        List<Client> result = clientRepository.findAll();
        // then - equals
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(clientOne, clientTwo);

    }
}