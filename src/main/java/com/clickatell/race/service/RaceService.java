package com.clickatell.race.service;

import com.clickatell.race.api.response.RaceWeatherForecastResponse;
import com.clickatell.race.client.RaceClient;
import com.clickatell.race.entity.Race;
import com.clickatell.race.entity.RaceResult;
import com.clickatell.race.repository.RaceRepository;
import com.clickatell.race.service.param.RaceParam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Service
public class RaceService {

    private final RaceClient raceClient;

    private final RaceRepository raceRepository;

    public RaceService(RaceClient raceClient, RaceRepository raceRepository) {
        this.raceClient = raceClient;
        this.raceRepository = raceRepository;
    }

    public Race createRace(RaceParam race) {
        return null;
    }

    public Race getRaceById(Long raceId) {
        Optional<Race> race = raceRepository.findById(raceId);
        return race.get();
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

    public RaceWeatherForecastResponse getWeatherForecastByRaceId(Long raceId) {
        //
        return null;
    }

    private RaceResult createRaceResult(RaceParam race) {
        return null;
    }
}
