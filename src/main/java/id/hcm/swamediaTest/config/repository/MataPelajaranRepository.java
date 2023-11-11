package id.hcm.swamediaTest.config.repository;

import id.hcm.swamediaTest.model.MataPelajaran;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MataPelajaranRepository extends JpaRepository<MataPelajaran, String> {
    List<MataPelajaran> findByNamaPelajaranContaining(String namaPelajaran);

    MataPelajaran findByCode(String code);
}
