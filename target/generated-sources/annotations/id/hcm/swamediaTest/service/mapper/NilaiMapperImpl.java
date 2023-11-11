package id.hcm.swamediaTest.service.mapper;

import id.hcm.swamediaTest.model.MataPelajaran;
import id.hcm.swamediaTest.model.Nilai;
import id.hcm.swamediaTest.service.dto.MataPelajaranDTO;
import id.hcm.swamediaTest.service.dto.NilaiDTO;
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
public class NilaiMapperImpl implements NilaiMapper {

    @Override
    public Nilai toEntity(NilaiDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Nilai nilai = new Nilai();

        nilai.setNis( dto.getNis() );
        nilai.setId( dto.getId() );
        nilai.setSemester( dto.getSemester() );
        nilai.setNilai( dto.getNilai() );
        nilai.setKodeNilai( dto.getKodeNilai() );
        nilai.setMataPelajaran( mataPelajaranDTOToMataPelajaran( dto.getMataPelajaran() ) );

        return nilai;
    }

    @Override
    public NilaiDTO toDto(Nilai nilai) {
        if ( nilai == null ) {
            return null;
        }

        NilaiDTO nilaiDTO = new NilaiDTO();

        nilaiDTO.setId( nilai.getId() );
        nilaiDTO.setNis( nilai.getNis() );
        nilaiDTO.setMataPelajaran( mataPelajaranToMataPelajaranDTO( nilai.getMataPelajaran() ) );
        nilaiDTO.setSemester( nilai.getSemester() );
        nilaiDTO.setNilai( nilai.getNilai() );
        nilaiDTO.setKodeNilai( nilai.getKodeNilai() );

        return nilaiDTO;
    }

    @Override
    public List<NilaiDTO> toDtoList(List<Nilai> nilaiList) {
        if ( nilaiList == null ) {
            return null;
        }

        List<NilaiDTO> list = new ArrayList<NilaiDTO>( nilaiList.size() );
        for ( Nilai nilai : nilaiList ) {
            list.add( toDto( nilai ) );
        }

        return list;
    }

    @Override
    public List<Nilai> toEntityList(List<NilaiDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Nilai> list = new ArrayList<Nilai>( dtoList.size() );
        for ( NilaiDTO nilaiDTO : dtoList ) {
            list.add( toEntity( nilaiDTO ) );
        }

        return list;
    }

    protected MataPelajaran mataPelajaranDTOToMataPelajaran(MataPelajaranDTO mataPelajaranDTO) {
        if ( mataPelajaranDTO == null ) {
            return null;
        }

        MataPelajaran mataPelajaran = new MataPelajaran();

        mataPelajaran.setCode( mataPelajaranDTO.getCode() );
        mataPelajaran.setNamaPelajaran( mataPelajaranDTO.getNamaPelajaran() );

        return mataPelajaran;
    }

    protected MataPelajaranDTO mataPelajaranToMataPelajaranDTO(MataPelajaran mataPelajaran) {
        if ( mataPelajaran == null ) {
            return null;
        }

        MataPelajaranDTO mataPelajaranDTO = new MataPelajaranDTO();

        mataPelajaranDTO.setCode( mataPelajaran.getCode() );
        mataPelajaranDTO.setNamaPelajaran( mataPelajaran.getNamaPelajaran() );

        return mataPelajaranDTO;
    }
}
