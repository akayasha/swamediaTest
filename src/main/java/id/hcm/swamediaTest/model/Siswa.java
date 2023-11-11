package id.hcm.swamediaTest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "siswa")
public class Siswa {
    @Id
    @Column(name = "nis") // Declare "nis" as the primary key
    private String nis;

    @Column(name = "namaSiswa")
    private String namaSiswa;

    @Column(name = "kelas")
    private String kelas;

    @Column(name = "jenisKelamin")
    private String jenisKelamin;

    @OneToMany(mappedBy = "siswa")
    private List<Nilai> nilaiList;



    // Default constructor
    public Siswa() {
    }

    // Parameterized constructor
    public Siswa(String nis, String namaSiswa, String kelas, String jenisKelamin) {
        this.nis = nis;
        this.namaSiswa = namaSiswa;
        this.kelas = kelas;
        this.jenisKelamin = jenisKelamin;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}
