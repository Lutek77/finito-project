package pl.coderslab.collapp.client;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }



    @Operation(summary = "add new client")
    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody @Valid ClientDTO client){
        ClientDTO clientDTO = clientService.addClient(client);
        return ResponseEntity.ok(clientDTO);
    }

    @Operation(summary = "Find client by id",  description = "Returns single Client")
    @GetMapping("/{id}")
    public ResponseEntity <ClientDTO> getById (@PathVariable Long id){
        ClientDTO client = clientService.getById(id);
        return  client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();

    }
    @Operation(summary = "update client")
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient (
            @PathVariable Long id, @RequestBody @Valid ClientDTO client){
        ClientDTO clientDTO = clientService.updateClient(id, client);
        return ResponseEntity.ok(clientDTO);


    }
    @Operation(summary = "delete client")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }






}
