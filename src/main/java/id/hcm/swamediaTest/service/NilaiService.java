package id.hcm.swamediaTest.service;

import id.hcm.swamediaTest.config.repository.MataPelajaranRepository;
import id.hcm.swamediaTest.config.repository.SiswaRepository;
import id.hcm.swamediaTest.model.MataPelajaran;
import id.hcm.swamediaTest.model.Siswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.hcm.swamediaTest.model.Nilai;
import id.hcm.swamediaTest.config.repository.NilaiRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NilaiService {

    private final NilaiRepository nilaiRepository;
    private final MataPelajaranRepository mataPelajaranRepository;

    private final SiswaRepository siswaRepository;

    @Autowired
    public NilaiService(NilaiRepository nilaiRepository, MataPelajaranRepository mataPelajaranRepository, SiswaRepository siswaRepository) {
        this.nilaiRepository = nilaiRepository;
        this.mataPelajaranRepository = mataPelajaranRepository;
        this.siswaRepository = siswaRepository;
    }

    public Nilai save(Nilai nilai) {

        // Check if the referenced codeMataPelajaran exists
        MataPelajaran mataPelajaran = mataPelajaranRepository.findByCode(nilai.getCodeMataPelajaran());
        if (mataPelajaran == null) {
            throw new RuntimeException("Mata Pelajaran with code " + nilai.getCodeMataPelajaran() + " not found.");
        }

        // Check if the referenced nis exists
        Siswa siswa = siswaRepository.findByNis(nilai.getNis());
        if (siswa == null) {
            throw new RuntimeException("Siswa with NIS " + nilai.getNis() + " not found.");
        }

        // Set the referenced entities
        nilai.setMataPelajaran(mataPelajaran);
        nilai.setSiswa(siswa);


        return nilaiRepository.save(nilai);
    }

    private boolean isValidNilai(Float nilai) {
        return nilai != null && (nilai >= 0 && nilai <= 100);
    }

    public List<Nilai> findAll() {
        return nilaiRepository.findAll();
    }

    public Optional<Nilai> findById(Long id) {
        return nilaiRepository.findById(id);
    }

    public void delete(Long id) {
        nilaiRepository.deleteById(id);
    }

    public List<Nilai> findByNisAndSemesterAndKodeNilai(String nis, Integer semester, String kodeNilai) {
        return nilaiRepository.findByNisAndSemesterAndKodeNilai(nis, semester, kodeNilai);
    }

    public List<Nilai> findBySemester(Integer semester) {
        return nilaiRepository.findBySemester(semester);
    }

    public List<Nilai> findByNisAndSemester(String nis, Integer semester) {
        return nilaiRepository.findByNisAndSemester(nis, semester);
    }
}
