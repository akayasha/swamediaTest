package id.hcm.swamediaTest.config.repository;

import id.hcm.swamediaTest.model.Nilai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NilaiRepository extends JpaRepository<Nilai, Long> {
        List<Nilai> findByNisAndSemesterAndKodeNilai(String nis, Integer semester, String kodeNilai);
        List<Nilai> findBySemester(Integer semester);
        List<Nilai> findByNisAndSemester(String nis, Integer semester);
}
