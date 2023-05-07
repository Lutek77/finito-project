package pl.coderslab.collapp.client;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import pl.coderslab.collapp.exception.IdMismatchException;
import pl.coderslab.collapp.exception.ResourceNotFoundException;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private  final ClientMapper clientMapper;


    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    // get client
    public ClientDTO getById (long id){
        return clientMapper.mapToDTO(clientRepository.findById(id).orElse(null));

    }


    // add client

    public ClientDTO addClient (ClientDTO clientDTO){
        Client client = clientMapper.mapToEntity(clientDTO);
        Assert.isNull(client.getId(), "not null");
        clientRepository.save(client);
        return clientMapper.mapToDTO(client);
    }

    // update client
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Assert.notNull(clientDTO.getId(), "cannot be empty");
        if (!clientDTO.getId().equals(id)) {
            throw new IdMismatchException("Id's mismatch");
        }
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Client doesn't exist");
        }
        Client client  = clientMapper.mapToEntity(clientDTO);
        clientRepository.save(client);
        return  clientMapper.mapToDTO(client);
    }

    // del

    public void deleteById (long id){
        clientRepository.deleteById(id);
    }




}
