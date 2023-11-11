package id.hcm.swamediaTest.model;

import javax.persistence.*;

@Entity
@Table(name = "ranking")
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nis")
    private String nis;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "ranking")
    private Integer ranking;

    @Transient // This annotation marks the field as non-persistent
    private Float totalScore;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nis", referencedColumnName = "nis", insertable = false, updatable = false)
    private Siswa siswa;


    // Default constructor
    public Ranking() {
    }

    public Float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Float totalScore) {
        this.totalScore = totalScore;
    }

    // Constructors with parameters
    public Ranking(String nis, Integer semester,Siswa siswa) {
        this.nis = nis;
        this.semester = semester;
        this.siswa = siswa;
    }

    public Siswa getSiswa() {
        return siswa;
    }

    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
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

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
}
