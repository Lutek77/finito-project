package pl.coderslab.collapp.client;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.coderslab.collapp.exception.IdMismatchException;
import pl.coderslab.collapp.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private  final ClientMapper clientMapper;
    private final ClientMapperTwo clientMapperTwo;


    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper, ClientMapperTwo clientMapperTwo) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
        this.clientMapperTwo = clientMapperTwo;
    }



    // get client with products and their details
    public ClientDTO getClientWithProductsAndDetails (long id){
        return clientMapper.mapToDTO(clientRepository.findById(id).orElse(null));

    }

    // get only data's client
    public ClientDTOTwo getClientById (Long id) {
    return clientMapperTwo.mapToDTo(clientRepository.findById(id).orElse(null));

    }


    // add client

    public ClientDTOTwo addClient (ClientDTOTwo clientDTOTwo){
        Client client = clientMapperTwo.mapToEntity(clientDTOTwo);
        Assert.isNull(client.getId(), "Id must be null");
        clientRepository.save(client);
        return clientMapperTwo.mapToDTo(client);
    }

    // update client
    public ClientDTOTwo updateClient(Long id, ClientDTOTwo clientDTOTwo) {
        Assert.notNull(clientDTOTwo.getId(), "cannot be empty");
        if (!clientDTOTwo.getId().equals(id)) {
            throw new IdMismatchException("Id's mismatch");
        }
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Client doesn't exist");
        }
        Client client  = clientMapperTwo.mapToEntity(clientDTOTwo);
        clientRepository.save(client);
        return  clientMapperTwo.mapToDTo(client);
    }

    // del

    public void deleteById (long id){
        clientRepository.deleteById(id);
    }



    // for test



}
