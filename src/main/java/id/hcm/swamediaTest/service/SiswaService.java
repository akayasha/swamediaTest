package id.hcm.swamediaTest.service;

import id.hcm.swamediaTest.model.Siswa;
import id.hcm.swamediaTest.config.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiswaService {

    private final SiswaRepository siswaRepository;

    @Autowired
    public SiswaService(SiswaRepository siswaRepository) {
        this.siswaRepository = siswaRepository;
    }

    public Siswa save(Siswa siswa) {
        return siswaRepository.save(siswa);
    }

    public List<Siswa> findAll() {
        return siswaRepository.findAll();
    }

    public Optional<Siswa> findById(String nis) {
        return siswaRepository.findById(nis);
    }

    public void delete(String nis) {
        siswaRepository.deleteById(nis);
    }

    public List<Siswa> findByFilter(String namaSiswa, String kelas, String jenisKelamin) {
        return siswaRepository.findByNamaSiswaContainingAndKelasContainingAndJenisKelaminContaining(
                namaSiswa, kelas, jenisKelamin);
    }
}
