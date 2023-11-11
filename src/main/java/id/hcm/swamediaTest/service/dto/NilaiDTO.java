package id.hcm.swamediaTest.service.dto;

public class NilaiDTO {
    private Long id;
    private String nis;
    private MataPelajaranDTO mataPelajaran;
    private Integer semester;
    private Float nilai;
    private String kodeNilai;

    // Constructors, getters, and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public MataPelajaranDTO getMataPelajaran() {
        return mataPelajaran;
    }

    public void setMataPelajaran(MataPelajaranDTO mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
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

    public void setNilai(Float nilai) {
        this.nilai = nilai;
    }

    public String getKodeNilai() {
        return kodeNilai;
    }

    public void setKodeNilai(String kodeNilai) {
        this.kodeNilai = kodeNilai;
    }
}
