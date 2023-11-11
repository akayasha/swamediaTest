package id.hcm.swamediaTest.service.mapper;

import id.hcm.swamediaTest.model.Siswa;
import id.hcm.swamediaTest.service.dto.SiswaDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface SiswaMapper extends EntityMapper<SiswaDTO, Siswa> {

    Siswa toEntity(SiswaDTO dto);

    SiswaDTO toDto(Siswa siswa);

    List<SiswaDTO> toDtoList(List<Siswa> siswaList); // Add this method for mapping lists

    List<Siswa> toEntityList(List<SiswaDTO> dtoList);

}