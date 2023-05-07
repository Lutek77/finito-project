package pl.coderslab.collapp.type;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    TypeDTO mapToDTO (Type type);
    List<TypeDTO> mapToDTO (List<Type> typeList);

    Type mapToEntity (TypeDTO typeDTO);
}
