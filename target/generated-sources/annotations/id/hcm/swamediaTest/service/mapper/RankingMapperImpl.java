package id.hcm.swamediaTest.service.mapper;

import id.hcm.swamediaTest.model.Ranking;
import id.hcm.swamediaTest.service.dto.RankingDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-25T09:40:09+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class RankingMapperImpl implements RankingMapper {

    @Override
    public Ranking toEntity(RankingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Ranking ranking = new Ranking();

        ranking.setId( dto.getId() );
        ranking.setNis( dto.getNis() );
        ranking.setSemester( dto.getSemester() );
        ranking.setRanking( dto.getRanking() );

        return ranking;
    }

    @Override
    public RankingDTO toDto(Ranking ranking) {
        if ( ranking == null ) {
            return null;
        }

        Long id = null;
        String nis = null;
        Integer ranking1 = null;
        Integer semester = null;

        id = ranking.getId();
        nis = ranking.getNis();
        ranking1 = ranking.getRanking();
        semester = ranking.getSemester();

        String kelas = null;

        RankingDTO rankingDTO = new RankingDTO( id, nis, ranking1, semester, kelas );

        return rankingDTO;
    }
}
