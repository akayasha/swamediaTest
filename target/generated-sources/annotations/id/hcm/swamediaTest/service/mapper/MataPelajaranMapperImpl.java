package id.hcm.swamediaTest.service.mapper;

import id.hcm.swamediaTest.model.MataPelajaran;
import id.hcm.swamediaTest.service.dto.MataPelajaranDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-25T09:40:09+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class MataPelajaranMapperImpl implements MataPelajaranMapper {

    @Override
    public MataPelajaran toEntity(MataPelajaranDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MataPelajaran mataPelajaran = new MataPelajaran();

        mataPelajaran.setCode( dto.getCode() );
        mataPelajaran.setNamaPelajaran( dto.getNamaPelajaran() );

        return mataPelajaran;
    }

    @Override
    public MataPelajaranDTO toDto(MataPelajaran mataPelajaran) {
        if ( mataPelajaran == null ) {
            return null;
        }

        MataPelajaranDTO mataPelajaranDTO = new MataPelajaranDTO();

        mataPelajaranDTO.setCode( mataPelajaran.getCode() );
        mataPelajaranDTO.setNamaPelajaran( mataPelajaran.getNamaPelajaran() );

        return mataPelajaranDTO;
    }

    @Override
    public List<MataPelajaranDTO> toDtoList(List<MataPelajaran> mataPelajaranList) {
        if ( mataPelajaranList == null ) {
            return null;
        }

        List<MataPelajaranDTO> list = new ArrayList<MataPelajaranDTO>( mataPelajaranList.size() );
        for ( MataPelajaran mataPelajaran : mataPelajaranList ) {
            list.add( toDto( mataPelajaran ) );
        }

        return list;
    }

    @Override
    public List<MataPelajaran> toEntityList(List<MataPelajaranDTO> mataPelajaranDTOList) {
        if ( mataPelajaranDTOList == null ) {
            return null;
        }

        List<MataPelajaran> list = new ArrayList<MataPelajaran>( mataPelajaranDTOList.size() );
        for ( MataPelajaranDTO mataPelajaranDTO : mataPelajaranDTOList ) {
            list.add( toEntity( mataPelajaranDTO ) );
        }

        return list;
    }
}
