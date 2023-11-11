package id.hcm.swamediaTest.service.mapper;

import id.hcm.swamediaTest.model.Ranking;
import id.hcm.swamediaTest.service.dto.RankingDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RankingMapper extends EntityMapper<RankingDTO, Ranking> {

    Ranking toEntity(RankingDTO dto);

    RankingDTO toDto(Ranking ranking);
}