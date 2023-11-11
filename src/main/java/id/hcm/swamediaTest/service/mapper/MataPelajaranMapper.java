package id.hcm.swamediaTest.service.mapper;

import id.hcm.swamediaTest.model.MataPelajaran;
import id.hcm.swamediaTest.service.dto.MataPelajaranDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MataPelajaranMapper extends EntityMapper<MataPelajaranDTO, MataPelajaran> {
    MataPelajaran toEntity(MataPelajaranDTO dto);

    MataPelajaranDTO toDto(MataPelajaran mataPelajaran);

    List<MataPelajaranDTO> toDtoList(List<MataPelajaran> mataPelajaranList);

    List<MataPelajaran> toEntityList(List<MataPelajaranDTO> mataPelajaranDTOList);
}