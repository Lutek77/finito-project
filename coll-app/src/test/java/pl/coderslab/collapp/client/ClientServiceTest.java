package pl.coderslab.collapp.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClientServiceTest {

    private ClientService service;
    private ClientRepository repository;


/*    @BeforeEach
    void setUp() {
        repository = mock(ClientRepository.class);
        service = new ClientService(repository);
    }*/

    @Test
    void getClientById() {

        
    }

    @Test
    void addClient() {

        // given
/*        ClientDTOTwo client = new ClientDTOTwo  (15L, "Ala", "Kot",
                "79010112345", "Otwock", "ala@wp.pl", 609100890  );
        when(repository.save(client)).thenReturn(client);
        // when
        ClientDTOTwo result = service.addClient(client);
        // then
        assertNotNull(result);
        assertEquals(client.getId(), result.getId());*/

    }

    @Test
    void updateClient() {
    }

    @Test
    void deleteById() {
    }
}