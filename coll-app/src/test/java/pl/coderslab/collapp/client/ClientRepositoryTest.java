package pl.coderslab.collapp.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.w3c.dom.stylesheets.LinkStyle;
import pl.coderslab.collapp.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClientRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Autowired
    ClientRepository clientRepository;

    ///@Sql(scripts = "classpath:data.sql")
    @Test
    void find_by_client_id() {
        // given - find
        ClientDTOTwo client = new ClientDTOTwo(100L, "Ala", "Kot",
                "79010112345", "Otwock", "ala@wp.pl", 609100890 );
        testEntityManager.persistAndFlush(client);
        // when - find in database
        Optional<Client> result = clientRepository.findById(100L);
        // then - equals
        assertEquals(client.getId(), result.get());

    }
}