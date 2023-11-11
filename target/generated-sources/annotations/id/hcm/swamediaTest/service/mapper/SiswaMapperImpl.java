package id.hcm.swamediaTest.service.mapper;

import id.hcm.swamediaTest.model.Siswa;
import id.hcm.swamediaTest.service.dto.SiswaDTO;
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
public class SiswaMapperImpl implements SiswaMapper {

    @Override
    public Siswa toEntity(SiswaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Siswa siswa = new Siswa();

        siswa.setNis( dto.getNis() );
        siswa.setNamaSiswa( dto.getNamaSiswa() );
        siswa.setKelas( dto.getKelas() );
        siswa.setJenisKelamin( dto.getJenisKelamin() );

        return siswa;
    }

    @Override
    public SiswaDTO toDto(Siswa siswa) {
        if ( siswa == null ) {
            return null;
        }

        SiswaDTO siswaDTO = new SiswaDTO();

        siswaDTO.setNis( siswa.getNis() );
        siswaDTO.setNamaSiswa( siswa.getNamaSiswa() );
        siswaDTO.setKelas( siswa.getKelas() );
        siswaDTO.setJenisKelamin( siswa.getJenisKelamin() );

        return siswaDTO;
    }

    @Override
    public List<SiswaDTO> toDtoList(List<Siswa> siswaList) {
        if ( siswaList == null ) {
            return null;
        }

        List<SiswaDTO> list = new ArrayList<SiswaDTO>( siswaList.size() );
        for ( Siswa siswa : siswaList ) {
            list.add( toDto( siswa ) );
        }

        return list;
    }

    @Override
    public List<Siswa> toEntityList(List<SiswaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Siswa> list = new ArrayList<Siswa>( dtoList.size() );
        for ( SiswaDTO siswaDTO : dtoList ) {
            list.add( toEntity( siswaDTO ) );
        }

        return list;
    }
}
