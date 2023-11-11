package id.hcm.swamediaTest.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mata_pelajaran")
public class MataPelajaran implements Serializable {
    @Id
    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "namaPelajaran")
    private String namaPelajaran;

    // Constructors, getters, and setters

    public MataPelajaran() {
    }

    public MataPelajaran(String code, String namaPelajaran) {
        this.code = code;
        this.namaPelajaran = namaPelajaran;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNamaPelajaran() {
        return namaPelajaran;
    }

    public void setNamaPelajaran(String namaPelajaran) {
        this.namaPelajaran = namaPelajaran;
    }
}
