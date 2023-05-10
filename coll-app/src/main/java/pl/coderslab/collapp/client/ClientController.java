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
    @PostMapping("/create")
    public ResponseEntity<ClientDTO> addClient(@RequestBody @Valid ClientDTO client){
        ClientDTO clientDTO = clientService.addClient(client);
        return ResponseEntity.ok(clientDTO);
    }

    @Operation(summary = "Find client by id with products and their details",
            description = "Returns single Client with products and their details")
    @GetMapping("/{id}/products/details/")
    public ResponseEntity <ClientDTO> getClientWithProductDetails (@PathVariable Long id){
        ClientDTO client = clientService.getClientWithProductsAndDetails(id);
        return  client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();

    }
    @Operation(summary = "update client")
    @PutMapping("/update/{id}")
    public ResponseEntity<ClientDTO> updateClient (
            @PathVariable Long id, @RequestBody @Valid ClientDTO client){
        ClientDTO clientDTO = clientService.updateClient(id, client);
        return ResponseEntity.ok(clientDTO);


    }
    @Operation(summary = "delete client")
    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }






}
