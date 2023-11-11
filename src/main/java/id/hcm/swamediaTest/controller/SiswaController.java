package id.hcm.swamediaTest.controller;

import id.hcm.swamediaTest.model.Siswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import id.hcm.swamediaTest.service.SiswaService;
import id.hcm.swamediaTest.service.dto.SiswaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/siswa")
public class SiswaController {

    private final SiswaService siswaService;

    @Autowired
    public SiswaController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }

    @PostMapping
    public ResponseEntity<Siswa> createSiswa(@RequestBody Siswa siswa) {
        Siswa result = siswaService.save(siswa);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<Siswa>> getAllSiswa() {
        List<Siswa> siswaList = siswaService.findAll();
        return ResponseEntity.ok(siswaList);
    }

    @GetMapping("/{nis}")
    public ResponseEntity<Siswa> getSiswaById(@PathVariable String nis) {
        Optional<Siswa> siswa = siswaService.findById(nis);
        return siswa.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{nis}")
    public ResponseEntity<Void> deleteSiswa(@PathVariable String nis) {
        siswaService.delete(nis);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Siswa>> getSiswaByFilter(
            @RequestParam(required = false) String namaSiswa,
            @RequestParam(required = false) String kelas,
            @RequestParam(required = false) String jenisKelamin) {
        List<Siswa> siswaList = siswaService.findByFilter(namaSiswa, kelas, jenisKelamin);
        return ResponseEntity.ok(siswaList);
    }
}
