package id.hcm.swamediaTest.config.repository;

import id.hcm.swamediaTest.model.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiswaRepository extends JpaRepository<Siswa, String> {
    List<Siswa> findByNamaSiswaContainingAndKelasContainingAndJenisKelaminContaining(
            String namaSiswa,
            String kelas,
            String jenisKelamin
    );

    Siswa findByNis(String nis);

}
