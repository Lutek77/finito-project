package pl.coderslab.collapp.detail;



import java.util.List;

public interface DetailMapper {
    DetailDTO mapToDTO (Detail detail);
    List<DetailDTO> mapToDTO (List<Detail> detailList);

    Detail mapToEntity (DetailDTO detailDTO);
}
