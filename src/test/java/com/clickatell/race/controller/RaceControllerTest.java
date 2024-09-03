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
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Emmanuel-Irabor
 * @since 03/09/2024
 */
@WebMvcTest(RaceController.class)
class RaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private RaceService raceService;

    @InjectMocks
    private RaceController raceController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateRider() throws Exception {
        RiderRequest riderRequest = new RiderRequest();
        RiderResponse riderResponse = new RiderResponse();
        when(raceService.createRider(any(RiderRequest.class))).thenReturn(riderResponse);

        mockMvc.perform(post("/create-rider")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(riderRequest)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(riderResponse)));
    }

    @Test
    void testCreateRace() throws Exception {
        RaceRequest raceRequest = new RaceRequest();
        RaceResponse raceResponse = new RaceResponse();
        when(raceService.createRace(any(RaceRequest.class))).thenReturn(raceResponse);

        mockMvc.perform(post("/create-race")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(raceRequest)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(raceResponse)));
    }

    @Test
    void testCreateRaceResult() throws Exception {
        RaceResultRequest raceResultRequest = new RaceResultRequest();
        RaceResultResponse raceResultResponse = new RaceResultResponse();
        when(raceService.createRaceResult(anyLong(), anyLong(), any(RaceResultRequest.class)))
                .thenReturn(raceResultResponse);

        mockMvc.perform(post("/1/1/create-result")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(raceResultRequest)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(raceResultResponse)));
    }

    @Test
    void testGetFastestRiders() throws Exception {
        List<RidersResponse> ridersResponses = new ArrayList<>();
        when(raceService.getFastestRiders(anyLong())).thenReturn(ridersResponses);

        mockMvc.perform(get("/1/fastest-riders"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(ridersResponses)));
    }

    @Test
    void testGetRidersWhoDidNotFinish() throws Exception {
        List<RidersResponse> ridersResponses = new ArrayList<>();
        when(raceService.getRidersWhoDidNotFinish(anyLong())).thenReturn(ridersResponses);

        mockMvc.perform(get("/1/riders-not-finished"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(ridersResponses)));
    }

    @Test
    void testGetRidersNotInRace() throws Exception {
        List<RidersResponse> ridersResponses = new ArrayList<>();
        when(raceService.getRidersNotInRace(anyLong())).thenReturn(ridersResponses);

        mockMvc.perform(get("/1/riders-not-in-race"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(ridersResponses)));
    }

    @Test
    void testGetWeatherByRaceId() throws Exception {
        WeatherForecastResponse weatherForecastResponse = new WeatherForecastResponse();
        when(raceService.getWeatherForecastByRaceId(anyLong())).thenReturn(weatherForecastResponse);

        mockMvc.perform(get("/get-weather-by-race-id/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(weatherForecastResponse)));
    }
}
