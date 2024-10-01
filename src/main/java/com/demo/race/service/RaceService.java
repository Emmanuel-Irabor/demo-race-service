package com.demo.race.service;

import com.demo.race.api.request.RaceRequest;
import com.demo.race.api.request.RaceResultRequest;
import com.demo.race.api.request.RiderRequest;
import com.demo.race.api.response.RaceResponse;
import com.demo.race.api.response.RaceResultResponse;
import com.demo.race.api.response.RiderResponse;
import com.demo.race.api.response.RidersResponse;
import com.demo.race.client.RaceClient;
import com.demo.race.client.response.WeatherForecastResponse;
import com.demo.race.common.Constants;
import com.demo.race.common.RaceRider;
import com.demo.race.common.exceptions.GeneralException;
import com.demo.race.common.exceptions.NoRecordFoundException;
import com.demo.race.converter.RaceConverter;
import com.demo.race.entity.Race;
import com.demo.race.entity.RaceResult;
import com.demo.race.entity.Rider;
import com.demo.race.repository.CustomRaceRepository;
import com.demo.race.repository.RaceRepository;
import com.demo.race.repository.RaceResultRepository;
import com.demo.race.repository.RiderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    private final RiderRepository riderRepository;

    private final CustomRaceRepository customRaceRepository;

    private final RaceResultRepository raceResultRepository;

    public RaceService(RaceClient raceClient, RaceRepository raceRepository,
                       RiderRepository riderRepository, CustomRaceRepository customRaceRepository,
                       RaceResultRepository raceResultRepository) {
        this.raceClient = raceClient;
        this.raceRepository = raceRepository;
        this.riderRepository = riderRepository;
        this.customRaceRepository = customRaceRepository;
        this.raceResultRepository = raceResultRepository;
    }

    public RaceResponse createRace(RaceRequest raceRequest) {
        // Convert RaceRequest to Race model
        Race raceModel = new Race();
        raceModel.setName(raceRequest.getName());
        raceModel.setCity(raceRequest.getLocation().getCity());
        raceModel.setLatitude(raceRequest.getLocation().getLatitude());
        raceModel.setLongitude(raceRequest.getLocation().getLongitude());
        raceModel.setType(raceRequest.getType());
        raceModel.setStartTime(raceRequest.getStartTime());

        // Fetch Riders from the repository based on their IDs in the request
        List<Rider> riders = new ArrayList<>();
        for (RaceRider raceRider : raceRequest.getRiders()) {
            Optional<Rider> riderOptional = riderRepository.findById(raceRider.getId());
            riderOptional.ifPresent(riders::add); // Add only if the rider exists
        }

        // Set the fetched riders to the Race model
        raceModel.setRiders(riders);

        // Save the Race entity to the database
        Race savedRaceEntity = raceRepository.save(raceModel);

        // Convert the saved Race entity to RaceResponse
        return RaceConverter.convertToRaceResponse(savedRaceEntity, riders);
    }

    public RiderResponse createRider(RiderRequest request) {
        Rider rider = new Rider();
        rider.setName(request.getRiderName());
        Rider savedRider = riderRepository.save(rider);
        return RaceConverter.convertToResponse(savedRider);
    }

    public List<RidersResponse> getFastestRiders(Long raceId) {
        List<Rider> riders = customRaceRepository.findFastestRidersByRaceId(raceId);
        if (riders == null || riders.isEmpty()) {
            throw new NoRecordFoundException(Constants.RECORD_NOT_FOUND);
        }
        return RaceConverter.convertToResponse(riders);
    }

    public List<RidersResponse> getRidersWhoDidNotFinish(Long raceId) {
        List<Rider> riders = customRaceRepository.findRidersWhoDidNotFinishByRaceId(raceId);
        if (riders == null || riders.isEmpty()) {
            throw new NoRecordFoundException(Constants.RECORD_NOT_FOUND);
        }
        return RaceConverter.convertToResponse(riders);
    }

    public List<RidersResponse> getRidersNotInRace(Long raceId) {
        List<Rider> riders = customRaceRepository.findRidersNotInRaceByRaceId(raceId);
        if (riders == null || riders.isEmpty()) {
            throw new NoRecordFoundException(Constants.RECORD_NOT_FOUND);
        }
        return RaceConverter.convertToResponse(riders);
    }

    public WeatherForecastResponse getWeatherForecastByRaceId(Long raceId) {
        Race race = raceRepository.findById(raceId)
                .orElseThrow(() -> new NoRecordFoundException("Race not found"));
        if (race.getLatitude() == null || race.getLongitude() == null) {
            throw new GeneralException(Constants.INTERNAL_SERVER_ERROR);
        }
        return raceClient.getWeatherForecast(race.getLatitude(), race.getLongitude());
    }

    public RaceResultResponse createRaceResult(Long raceId, Long riderId, RaceResultRequest raceResultRequest) {
        // Fetch the Race and Rider entities
        Race race = raceRepository.findById(raceId)
                .orElseThrow(() -> new NoRecordFoundException("Race not found"));
        Rider rider = riderRepository.findById(riderId)
                .orElseThrow(() -> new NoRecordFoundException("Rider not found"));

        // Create and set properties of RaceResult
        RaceResult raceResult = new RaceResult();
        raceResult.setRace(race);
        raceResult.setRider(rider);
        raceResult.setFinishTime(raceResultRequest.getFinishTime());
        raceResult.setFinished(raceResultRequest.isFinished());

        // Save and return the RaceResult
        RaceResult savedRaceResult = raceResultRepository.save(raceResult);
        return RaceConverter.convertToResponse(savedRaceResult);
    }
}
