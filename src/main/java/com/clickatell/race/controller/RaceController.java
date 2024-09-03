package com.clickatell.race.controller;

import com.clickatell.race.api.request.RaceRequest;
import com.clickatell.race.api.request.RaceResultRequest;
import com.clickatell.race.api.request.RiderRequest;
import com.clickatell.race.api.response.RaceResponse;
import com.clickatell.race.api.response.RaceResultResponse;
import com.clickatell.race.api.response.RiderResponse;
import com.clickatell.race.api.response.RidersResponse;
import com.clickatell.race.client.response.WeatherForecastResponse;
import com.clickatell.race.service.RaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@RestController
@RequestMapping("/api/v1/races")
public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @PostMapping("/create-rider")
    public ResponseEntity<RiderResponse> createRider(@RequestBody @Valid RiderRequest request) {
        RiderResponse response = raceService.createRider(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create-race")
    public ResponseEntity<RaceResponse> createRace(@RequestBody @Valid RaceRequest request) {
        RaceResponse response = raceService.createRace(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/{raceId}/{riderId}/create-result")
    public ResponseEntity<RaceResultResponse> createRaceResult(@PathVariable Long raceId, @PathVariable Long riderId,
                                                               @RequestBody RaceResultRequest request) {
        RaceResultResponse response = raceService.createRaceResult(raceId, riderId, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{raceId}/fastest-riders")
    public ResponseEntity<List<RidersResponse>> getFastestRiders(@PathVariable Long raceId) {
        List<RidersResponse> response = raceService.getFastestRiders(raceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{raceId}/riders-not-finished")
    public ResponseEntity<List<RidersResponse>> getRidersWhoDidNotFinish(@PathVariable Long raceId) {
        List<RidersResponse> response = raceService.getRidersWhoDidNotFinish(raceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{raceId}/riders-not-in-race")
    public ResponseEntity<List<RidersResponse>> getRidersNotInRace(@PathVariable Long raceId) {
        List<RidersResponse> response = raceService.getRidersNotInRace(raceId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-weather-by-race-id/{raceId}")
    public ResponseEntity<WeatherForecastResponse> createRace(@PathVariable Long raceId) {
        WeatherForecastResponse response = raceService.getWeatherForecastByRaceId(raceId);
        return ResponseEntity.ok(response);
    }
}
