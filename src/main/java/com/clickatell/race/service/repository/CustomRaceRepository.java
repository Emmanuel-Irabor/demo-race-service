package com.clickatell.race.service.repository;

import com.clickatell.race.service.entity.Race;
import com.clickatell.race.service.entity.RaceResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Repository
public interface CustomRaceRepository {

    List<RaceResult> findTop3ByRaceOrderByFinishTimeAsc(Race race);

    List<RaceResult> findByRaceAndFinishedFalse(Race race);

    List<RaceResult> findByRace(Race race);
}
