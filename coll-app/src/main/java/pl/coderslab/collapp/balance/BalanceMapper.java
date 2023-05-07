package pl.coderslab.collapp.balance;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BalanceMapper {

    BalanceDTO mapToDTO (Balance balance);
    List<BalanceDTO> mapToDTO (List<Balance> balanceList);

    Balance mapToEntity (BalanceDTO balanceDTO);

}
