package id.hcm.swamediaTest.controller;

import id.hcm.swamediaTest.model.Ranking;
import id.hcm.swamediaTest.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/ranking")
public class RankingController {

    private final RankingService rankingService;

    @Autowired
    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @PostMapping("/calculate-and-save-ranking")
    public ResponseEntity<String> calculateAndSaveRankings(@RequestParam Integer semester) {
        try {
            // Call a service method to calculate and create student rankings for the given semester
            rankingService.calculateAndSaveRankings(semester);
            return ResponseEntity.ok("Student rankings calculated and saved successfully for Semester " + semester);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error calculating and saving student rankings: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRanking(@PathVariable Long id) {
        rankingService.delete(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/by-nis-semester")
//    public ResponseEntity<List<Ranking>> getRankingByNisAndSemester(
//            @RequestParam String nis,
//            @RequestParam Integer semester) {
//        List<Ranking> rankingList = rankingService.findByNisAndSemester(nis, semester);
//        return ResponseEntity.ok(rankingList);
//    }

    @GetMapping("/by-semester")
    public ResponseEntity<List<Ranking>> getRankingBySemester(
            @RequestParam Integer semester) {
        List<Ranking> rankingList = rankingService.findBySemester(semester);
        return ResponseEntity.ok(rankingList);
    }

    @GetMapping("/by-semester-ranking")
    public ResponseEntity<List<Ranking>> getRankingBySemesterAndRanking(
            @RequestParam Integer semester,
            @RequestParam Integer ranking) {
        List<Ranking> rankingList = rankingService.findBySemesterAndRanking(semester, ranking);
        return ResponseEntity.ok(rankingList);
    }

    @GetMapping("/by-kelas-semester")
    public ResponseEntity<List<Ranking>> getRankingByKelasAndSemester(
            @RequestParam String kelas,
            @RequestParam Integer semester) {
        List<Ranking> rankingList = rankingService.findByKelasAndSemester(kelas, semester);

        // Mengurutkan rankingList secara ascending berdasarkan totalScore
        Collections.sort(rankingList, (r1, r2) -> {
            if (r1.getTotalScore() == null || r2.getTotalScore() == null) {
                return 0; // Sesuaikan dengan kondisi khusus jika totalScore bisa null
            }
            return Float.compare(r1.getTotalScore(), r2.getTotalScore());
        });

        return ResponseEntity.ok(rankingList);
    }


}
