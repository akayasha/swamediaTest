package id.hcm.swamediaTest.service;

import id.hcm.swamediaTest.config.repository.NilaiRepository;
import id.hcm.swamediaTest.config.repository.SiswaRepository;
import id.hcm.swamediaTest.model.Nilai;
import id.hcm.swamediaTest.model.Ranking;
import id.hcm.swamediaTest.config.repository.RankingRepository;
import id.hcm.swamediaTest.model.Siswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RankingService {

    private final RankingRepository rankingRepository;
    private final NilaiRepository nilaiRepository;

    private final SiswaRepository siswaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RankingService(RankingRepository rankingRepository, NilaiRepository nilaiRepository, SiswaRepository siswaRepository) {
        this.rankingRepository = rankingRepository;
        this.nilaiRepository = nilaiRepository;
        this.siswaRepository = siswaRepository;
    }

    @Transactional
    public void calculateAndSaveRankings(Integer semester) {
        try {
            // Retrieve student grades for the specified semester
            List<Nilai> nilaiList = nilaiRepository.findBySemester(semester);

            // Create an empty map to store total scores for each class
            Map<String, Map<String, Float>> totalScoresByClass = new HashMap<>();

            // Calculate total scores and group students by class
            for (Nilai nilai : nilaiList) {
                String nis = nilai.getNis();
                Float score = nilai.getNilai();

                // Get the corresponding student from the database
                Ranking ranking = rankingRepository.findByNisAndSemester(nis, semester);

                if (ranking != null) {
                    Siswa siswa = ranking.getSiswa();

                    if (siswa != null) {
                        String kelas = siswa.getKelas();

                        // Check if the class is already in the map, and if not, initialize it
                        totalScoresByClass.putIfAbsent(kelas, new HashMap<>());

                        // Get the total score map for the class
                        Map<String, Float> totalScores = totalScoresByClass.get(kelas);

                        // Check if the student already has a total score, and if not, initialize it to 0.0
                        totalScores.putIfAbsent(nis, 0.0F);

                        // Add the current score to the total score
                        totalScores.put(nis, totalScores.get(nis) + score);
                    }
                }
            }

            // Iterate over each class
            for (Map.Entry<String, Map<String, Float>> entry : totalScoresByClass.entrySet()) {
                String kelas = entry.getKey();
                Map<String, Float> totalScores = entry.getValue();

                // Sort total scores in descending order
                List<Map.Entry<String, Float>> sortedScores = totalScores.entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Float>comparingByValue().reversed())
                        .collect(Collectors.toList());

                // Update the ranking based on the sorted order
                int rank = 1;
                for (Map.Entry<String, Float> scoreEntry : sortedScores) {
                    String nis = scoreEntry.getKey();
                    Float totalScore = scoreEntry.getValue();

                    // Get the corresponding Ranking entity for the semester and student
                    Ranking ranking = rankingRepository.findByNisAndSemester(nis, semester);

                    if (ranking != null) {
                        // Update the ranking based on the current rank value
                        ranking.setTotalScore(totalScore);
                        ranking.setRanking(rank);

                        // Save the updated Ranking entity to the database
                        rankingRepository.save(ranking);

                        System.out.println("nis: " + nis + ", semester: " + semester + ", totalScore: " + totalScore);

                        // Increment the rank
                        rank++;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error calculating and saving student rankings: " + e.getMessage(), e);
        }
    }



    public List<Ranking> findByKelasAndSemester(String kelas, Integer semester) {
        return rankingRepository.findByKelasAndSemester(kelas, semester);
    }


    public List<Ranking> findAll() {
        return rankingRepository.findAll();
    }

//    public List<Ranking> findByNisAndSemester(String nis, Integer semester) {
//        return rankingRepository.findByNisAndSemester(nis, semester);
//    }

    public List<Ranking> findBySemester(Integer semester) {
        return rankingRepository.findBySemester(semester);
    }

    public List<Ranking> findBySemesterAndRanking(Integer semester, Integer ranking) {
        return rankingRepository.findBySemesterAndRanking(semester, ranking);
    }

    public void delete(Long id) {
        rankingRepository.deleteById(id);
    }

    public Ranking findById(Long id) {
        return rankingRepository.findById(id).orElse(null);
    }

//    public List<Ranking> findByNisAndSemester(String nis, Integer semester) {
//        return rankingRepository.findByNisAndSemester(nis, semester);
//    }
}
