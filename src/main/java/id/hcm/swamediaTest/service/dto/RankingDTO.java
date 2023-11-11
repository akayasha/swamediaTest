package id.hcm.swamediaTest.service.dto;

public class RankingDTO {
    private Long id;
    private String nis;
    private Integer ranking;
    private Integer semester;
    private String kelas;

    public RankingDTO(Long id, String nis, Integer ranking, Integer semester, String kelas) {
        this.id = id;
        this.nis = nis;
        this.ranking = ranking;
        this.semester = semester;
        this.kelas = kelas;
    }

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

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
