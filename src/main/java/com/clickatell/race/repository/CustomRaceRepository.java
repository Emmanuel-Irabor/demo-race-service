package com.clickatell.race.repository;

import com.clickatell.race.entity.Rider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Repository
public interface CustomRaceRepository {

    List<Rider> findFastestRidersByRaceId(Long raceId);

    List<Rider> findRidersWhoDidNotFinishByRaceId(Long raceId);

    List<Rider> findRidersNotInRaceByRaceId(Long raceId);
}
