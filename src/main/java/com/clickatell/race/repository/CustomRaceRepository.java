package com.clickatell.race.repository;

import com.clickatell.race.entity.Race;
import com.clickatell.race.entity.RaceResult;
import com.clickatell.race.entity.Rider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Repository
public interface CustomRaceRepository {

    List<RaceResult> findFastestByRaceOrderByFinishTimeAsc(Race race);

    List<RaceResult> findByRaceAndFinishedFalse(Race race);

    List<Rider> findRidersNotInRace(Race race);
}
