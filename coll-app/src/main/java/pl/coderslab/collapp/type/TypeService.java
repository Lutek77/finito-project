package pl.coderslab.collapp.type;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.coderslab.collapp.exception.IdMismatchException;
import pl.coderslab.collapp.exception.ResourceNotFoundException;

@Service
public class TypeService {

    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;

    public TypeService(TypeRepository typeRepository, TypeMapper typeMapper) {
        this.typeRepository = typeRepository;
        this.typeMapper = typeMapper;
    }

    //add
    public TypeDTO addType(TypeDTO typeDTO){
        Type type = typeMapper.mapToEntity(typeDTO);
        Assert.isNull(type.getId(),"not null");
        typeRepository.save(type);
        return typeMapper.mapToDTO(type);


    }

    //update

    public TypeDTO updateById (Long id, TypeDTO typeDTO){

        Assert.isNull(typeDTO.getId(),"not null");
        if (!typeDTO.getId().equals(id)) {
            throw new IdMismatchException("Id's mismatch");
        }
        if (!typeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Client doesn't exist");
        }

        Type type = typeMapper.mapToEntity(typeDTO);
        typeRepository.save(type);
        return typeMapper.mapToDTO(type);


    }

    // delete
    public void deleteById(Long id){
        typeRepository.deleteById(id);
    }


}
