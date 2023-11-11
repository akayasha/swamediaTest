package id.hcm.swamediaTest.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "nilai")
public class Nilai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code_mata_pelajaran")
    private String codeMataPelajaran;

    @ManyToOne
    @JoinColumn(name = "code_mata_pelajaran", referencedColumnName = "code", insertable = false, updatable = false)
    private MataPelajaran mataPelajaran;

    public Nilai() {

    }

    public String getCodeMataPelajaran() {
        return codeMataPelajaran;
    }

    public void setCodeMataPelajaran(String codeMataPelajaran) {
        this.codeMataPelajaran = codeMataPelajaran;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public Siswa getSiswa() {
        return siswa;
    }

    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }

    @Column(name = "nis")
    private String nis;

    @ManyToOne
    @JoinColumn(name = "nis", referencedColumnName = "nis", insertable = false, updatable = false)
    private Siswa siswa;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "kodeNilai")
    private String kodeNilai;

    @Column(name = "nilai")
    private Float nilai;

    // Constructors, getters, and setters

    public Nilai(Long id, String codeMataPelajaran, MataPelajaran mataPelajaran, String nis, Siswa siswa, Integer semester, String kodeNilai, Float nilai) {
        this.id = id;
        this.codeMataPelajaran = codeMataPelajaran;
        this.mataPelajaran = mataPelajaran;
        this.nis = nis;
        this.siswa = siswa;
        this.semester = semester;
        this.kodeNilai = kodeNilai;
        this.nilai = nilai;
    }

    public String calculateKodeNilai() {
        if (nilai == null) {
            return "DEFAULT_VALUE";
        }
        if (nilai >= 0 && nilai <= 59) {
            return "E";
        } else if (nilai >= 60 && nilai <= 69) {
            return "D";
        } else if (nilai >= 70 && nilai <= 79) {
            return "C";
        } else if (nilai >= 80 && nilai <= 89) {
            return "B";
        } else if (nilai >= 90 && nilai <= 100) {
            return "A";
        } else {
            return "ERROR"; // Default jika nilai tidak sesuai
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Float getNilai() {
        return nilai;
    }

    public Map<String, Object> setNilai(Float nilai) {
        Map<String, Object> response = new HashMap<>();

        if (nilai != null && (nilai >= 0 && nilai <= 100)) {
            this.nilai = nilai;
            this.kodeNilai = calculateKodeNilai();
            response.put("success", true);
            response.put("message", "Nilai successfully updated");
        } else {
            response.put("success", false);
            response.put("message", "Nilai lebih dari 100 atau bernilai negatif");
        }

        return response;
    }

    public String getKodeNilai() {
        return kodeNilai;
    }

    public void setKodeNilai(String kodeNilai) {
        this.kodeNilai = kodeNilai;
    }

    public MataPelajaran getMataPelajaran() {
        return mataPelajaran;
    }

    public void setMataPelajaran(MataPelajaran mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }
}
