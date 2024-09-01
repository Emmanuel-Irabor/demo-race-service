package com.clickatell.race.controller;

import com.clickatell.race.api.request.RaceRequest;
import com.clickatell.race.api.response.RaceResponse;
import com.clickatell.race.service.RaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/create-race")
    public ResponseEntity<RaceResponse> createRace(@RequestBody RaceRequest raceRequest) {
        //TODO: implement createRace
        return new ResponseEntity<>(new RaceResponse(), HttpStatus.CREATED);
    }


}
