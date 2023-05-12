package pl.coderslab.collapp.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClientServiceTest {

    private ClientService service;
    private ClientRepository repository;


/*    @BeforeEach
    void setUp() {
        clientRepository = mock(ClientRepository.class);
        service = new ClientService(clientRepository);
    }*/

    @Test
    void getClientById() {

        
    }

    @Test
    void addClient() {

/*        // given
        ClientDTOTwo clientDTOTwo = new ClientDTOTwo(15L, "Ala", "Kot",
                "79010112345", "Otwock", "ala@wp.pl", 609100890 );
        when(repository.save(clientDTOTwo)).thenReturn(clientDTOTwo);
        // when
        ClientDTOTwo result = service.addClient(clientDTOTwo);
        // then
        assertNotNull(result);
        assertEquals(clientDTOTwo.getId(), result.getId());*/

    }

    @Test
    void updateClient() {
    }

    @Test
    void deleteById() {
    }
}