package pl.coderslab.collapp.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ClientController.class)
class ClientControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ClientService clientService;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void addClient() throws Exception {

        // given
        ClientDTOTwo client = new ClientDTOTwo(10L, "Adam", "Stach", "50010104637",
                "Wrocław", "adam12@op.pl", 532189400);
        when(clientService.addClient(client))
                .thenReturn(new ClientDTOTwo(10L, "Adam", "Stach", "50010104637",
                        "Wrocław", "adam12@op.pl", 532189400));
        // then
        mockMvc.perform(post("/api/clients/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(client)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("Adam")))
                .andExpect(jsonPath("$.lastName", is("Stach")))
                .andExpect(jsonPath("$.pesel", is("50010104637")))
                .andExpect(jsonPath("$.address", is("Wrocław")))
                .andExpect(jsonPath("$.email", is("adam12@op.pl")))
                .andExpect(jsonPath("$.phoneNumber", is(532189400)));
    }




    @Test
    void getClientByID() throws Exception {
        // given
        when(clientService.getClientById(1L)).thenReturn(
                new ClientDTOTwo(1L, "Adam", "Stach", "50010104637",
                        "Wrocław", "adam12@op.pl", 532189400));
        // then
        mockMvc.perform(get("/api/clients/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("Adam")))
                .andExpect(jsonPath("$.lastName", is("Stach")))
                .andExpect(jsonPath("$.pesel", is("50010104637")))
                .andExpect(jsonPath("$.address", is("Wrocław")))
                .andExpect(jsonPath("$.email", is("adam12@op.pl")))
                .andExpect(jsonPath("$.phoneNumber", is(532189400)));

    }

    @Test
    void updateClientById() throws Exception {

        // given
        ClientDTOTwo client = new ClientDTOTwo(5L, "Adam", "Stach", "50010104637",
                "Wrocław", "adam12@op.pl", 532189400);
        when(clientService.updateClient(5L, client)).thenReturn(client);
        // then
        mockMvc.perform(put("/api/students/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(client)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("Adam")))
                .andExpect(jsonPath("$.lastName", is("Stach")))
                .andExpect(jsonPath("$.pesel", is("50010104637")))
                .andExpect(jsonPath("$.address", is("Wrocław")))
                .andExpect(jsonPath("$.email", is("adam12@op.pl")))
                .andExpect(jsonPath("$.phoneNumber", is(532189400)));

    }

    @Test
    void deleteClientById() throws Exception{
        mockMvc.perform(delete("/api/clients/del/1"))
                .andExpect(status().isNoContent());
              verify(clientService, times(1)).deleteById(1L);

    }
}