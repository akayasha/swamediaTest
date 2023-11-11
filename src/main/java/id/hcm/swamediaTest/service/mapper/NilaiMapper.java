package id.hcm.swamediaTest.service.mapper;

import id.hcm.swamediaTest.model.Nilai;
import id.hcm.swamediaTest.service.dto.NilaiDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NilaiMapper extends EntityMapper<NilaiDTO, Nilai> {
    Nilai toEntity(NilaiDTO dto);

    NilaiDTO toDto(Nilai nilai);

    List<NilaiDTO> toDtoList(List<Nilai> nilaiList);

    List<Nilai> toEntityList(List<NilaiDTO> dtoList);

}