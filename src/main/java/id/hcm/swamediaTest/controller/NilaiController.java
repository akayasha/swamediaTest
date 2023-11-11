package id.hcm.swamediaTest.controller;

import id.hcm.swamediaTest.model.Nilai;
import id.hcm.swamediaTest.service.NilaiService;
import id.hcm.swamediaTest.service.dto.NilaiDTO;
import id.hcm.swamediaTest.service.dto.SiswaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/nilai")
public class NilaiController {

    private final NilaiService nilaiService;

    @Autowired
    public NilaiController(NilaiService nilaiService) {
        this.nilaiService = nilaiService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createNilai(@RequestBody Nilai nilai) {
        Map<String, Object> response = nilai.setNilai(nilai.getNilai());

        if ((boolean) response.get("success")) {
            Nilai result = nilaiService.save(nilai);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping
    public ResponseEntity<List<Nilai>> getAllNilai() {
        List<Nilai> nilaiList = nilaiService.findAll();
        return ResponseEntity.ok(nilaiList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nilai> getNilaiById(@PathVariable Long id) {
        Optional<Nilai> nilai = nilaiService.findById(id);
        return nilai.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNilai(@PathVariable Long id) {
        nilaiService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-nis-semester")
    public ResponseEntity<List<Nilai>> getNilaiByNisAndSemester(
            @RequestParam String nis,
            @RequestParam Integer semester) {
        List<Nilai> nilaiList = nilaiService.findByNisAndSemester(nis, semester);
        return ResponseEntity.ok(nilaiList);
    }

    @GetMapping("/by-semester")
    public ResponseEntity<List<Nilai>> getNilaiBySemester(
            @RequestParam Integer semester) {
        List<Nilai> nilaiList = nilaiService.findBySemester(semester);
        return ResponseEntity.ok(nilaiList);
    }

    @GetMapping("/by-nis-semester-kode")
    public ResponseEntity<List<Nilai>> getNilaiByNisAndSemesterAndKodeNilai(
            @RequestParam String nis,
            @RequestParam Integer semester,
            @RequestParam String kodeNilai) {
        List<Nilai> nilaiList = nilaiService.findByNisAndSemesterAndKodeNilai(nis, semester, kodeNilai);
        return ResponseEntity.ok(nilaiList);
    }
}

