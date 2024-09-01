package com.clickatell.race.service;

import com.clickatell.race.entity.Race;
import com.clickatell.race.entity.RaceResult;
import com.clickatell.race.service.param.RaceParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Service
public class RaceService {

    public Race createRace(RaceParam race) {
        return null;
    }

    public RaceResult endRaceById (Long raceId) {
        return null;
    }

    public List<RaceResult> getFastestThreeRiders(RaceParam race) {
        return null;
    }

    public List<RaceResult> getRidersWhoDidNotFinish(RaceParam race) {
        return null;
    }

    public List<RaceResult> getRidersNotInRace(RaceParam race) {
        return null;
    }

    private RaceResult createRaceResult(RaceParam race) {
        return null;
    }
}
