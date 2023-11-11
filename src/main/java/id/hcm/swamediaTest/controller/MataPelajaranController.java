package id.hcm.swamediaTest.controller;


import id.hcm.swamediaTest.model.MataPelajaran;
import id.hcm.swamediaTest.service.MataPelajaranService;
import id.hcm.swamediaTest.service.dto.MataPelajaranDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mata-pelajaran")
public class MataPelajaranController {

    private final MataPelajaranService mataPelajaranService;

    @Autowired
    public MataPelajaranController(MataPelajaranService mataPelajaranService) {
        this.mataPelajaranService = mataPelajaranService;
    }

    @PostMapping
    public ResponseEntity<MataPelajaran> createMataPelajaran(@RequestBody MataPelajaran mataPelajaran) {
        MataPelajaran result = mataPelajaranService.save(mataPelajaran);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<MataPelajaran>> getAllMataPelajaran() {
        List<MataPelajaran> mataPelajaranList = mataPelajaranService.findAll();
        return ResponseEntity.ok(mataPelajaranList);
    }

    @GetMapping("/{code}")
    public ResponseEntity<MataPelajaran> getMataPelajaranByCode(@PathVariable String code) {
        Optional<MataPelajaran> mataPelajaran = mataPelajaranService.findByCode(code);
        return mataPelajaran.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteMataPelajaran(@PathVariable String code) {
        mataPelajaranService.delete(code);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<MataPelajaran>> getMataPelajaranByNamaPelajaran(
            @RequestParam(required = false) String namaPelajaran) {
        List<MataPelajaran> mataPelajaranList = mataPelajaranService.findByNamaPelajaran(namaPelajaran);
        return ResponseEntity.ok(mataPelajaranList);
    }
}
