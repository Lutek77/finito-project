package pl.coderslab.collapp.client;

import org.mapstruct.Mapper;

import java.awt.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapperTwo {

    ClientDTOTwo mapToDTo (Client client);

    Client mapToEntity (ClientDTOTwo clientDTOTwo);
}
