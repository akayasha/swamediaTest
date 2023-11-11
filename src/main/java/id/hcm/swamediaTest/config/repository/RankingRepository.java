package id.hcm.swamediaTest.config.repository;

import id.hcm.swamediaTest.model.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
//    List<Ranking> findByNisAndSemester(String nis, Integer semester);
    List<Ranking> findBySemester(Integer semester);
    List<Ranking> findBySemesterAndRanking(Integer semester, Integer ranking);

    @Query("SELECT r FROM Ranking r JOIN r.siswa s WHERE s.kelas = :kelas")
    List<Ranking> findByKelas(@Param("kelas") String kelas);
    Ranking findByNisAndSemester(String nis, Integer semester);

    @Query("SELECT r FROM Ranking r JOIN r.siswa s WHERE s.kelas = :kelas AND r.semester = :semester")
    List<Ranking> findByKelasAndSemester(@Param("kelas") String kelas, @Param("semester") Integer semester);

}
