package id.hcm.swamediaTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.hcm.swamediaTest.model.MataPelajaran;
import id.hcm.swamediaTest.config.repository.MataPelajaranRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MataPelajaranService {

    private final MataPelajaranRepository mataPelajaranRepository;

    @Autowired
    public MataPelajaranService(MataPelajaranRepository mataPelajaranRepository) {
        this.mataPelajaranRepository = mataPelajaranRepository;
    }

    public MataPelajaran save(MataPelajaran mataPelajaran) {
        return mataPelajaranRepository.save(mataPelajaran);
    }

    public List<MataPelajaran> findAll() {
        return mataPelajaranRepository.findAll();
    }

    public Optional<MataPelajaran> findByCode(String code) {
        return mataPelajaranRepository.findById(code);
    }

    public void delete(String code) {
        mataPelajaranRepository.deleteById(code);
    }

    public List<MataPelajaran> findByNamaPelajaran(String namaPelajaran) {
        return mataPelajaranRepository.findByNamaPelajaranContaining(namaPelajaran);
    }
}
