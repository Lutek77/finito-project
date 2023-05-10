package pl.coderslab.collapp.client;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO mapToDTO (Client client);
    List<ClientDTO> mapToDTO (List<Client> clientList);
    Client mapToEntity (ClientDTO clientDTO) ;

}
