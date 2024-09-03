package com.clickatell.race.converter;

import com.clickatell.race.api.response.RaceResponse;
import com.clickatell.race.api.response.RaceResultResponse;
import com.clickatell.race.api.response.RiderResponse;
import com.clickatell.race.api.response.RidersResponse;
import com.clickatell.race.common.Constants;
import com.clickatell.race.common.RaceInfo;
import com.clickatell.race.common.RaceLocationInfo;
import com.clickatell.race.common.RiderInfo;
import com.clickatell.race.entity.Race;
import com.clickatell.race.entity.RaceResult;
import com.clickatell.race.entity.Rider;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
public class RaceConverter {

    public static RiderResponse convertToResponse(Rider rider) {
        if (rider == null) {
            throw new InvalidParameterException("Rider cannot be null!");
        }
        RiderResponse riderResponse = new RiderResponse();
        riderResponse.setId(rider.getId());
        riderResponse.setName(rider.getName());
        return riderResponse;
    }

    public static List<RidersResponse> convertToResponse(List<Rider> riders) {
        if (riders == null) {
            throw new InvalidParameterException("Riders cannot be null!");
        }
        RidersResponse ridersResponse = new RidersResponse();
        List<RiderInfo> riderInfoList = riders.stream().map(rider -> {
                    RiderInfo info = new RiderInfo();
                    info.setId(rider.getId());
                    info.setName(rider.getName());
                    return info;
                }).collect(Collectors.toList());
        ridersResponse.setRiders(riderInfoList);
        return Collections.singletonList(ridersResponse);
    }

    public static RaceResponse convertToRaceResponse(Race race, List<Rider> riders) {
        if (race == null || riders == null) {
            throw new InvalidParameterException(Constants.INVALID_PARAMETERS);
        }
        RaceResponse raceResponse = new RaceResponse();
        RaceInfo raceInfo = new RaceInfo();
        raceInfo.setId(race.getId());
        raceInfo.setName(race.getName());
        raceInfo.setType(race.getType());
        raceInfo.setStartTime(race.getStartTime());

        List<RiderInfo> riderInfoList = riders.stream().map(rider -> {
                    RiderInfo info = new RiderInfo();
                    info.setId(rider.getId());
                    info.setName(rider.getName());
                    return info;
                }).collect(Collectors.toList());
        raceInfo.setRiders(riderInfoList);

        RaceLocationInfo locationInfo = new RaceLocationInfo();
        locationInfo.setCity(race.getCity());
        locationInfo.setLatitude(race.getLatitude());
        locationInfo.setLongitude(race.getLongitude());

        raceInfo.setLocation(locationInfo);

        List<RaceInfo> raceInfoList = new ArrayList<>();
        raceInfoList.add(raceInfo);

        raceResponse.setRace(raceInfoList);
        return raceResponse;
    }

    public static RaceResultResponse convertToResponse (RaceResult raceResult) {
        if (raceResult == null) {
            throw new InvalidParameterException(Constants.INVALID_PARAMETERS);
        }
        RaceResultResponse raceResultResponse = new RaceResultResponse();
        raceResultResponse.setId(raceResult.getId());

        Race race = raceResult.getRace();
        RaceLocationInfo locationInfo = new RaceLocationInfo();
        locationInfo.setCity(race.getCity());
        locationInfo.setLatitude(race.getLatitude());
        locationInfo.setLongitude(race.getLongitude());

        RaceInfo raceInfo = new RaceInfo();
        raceInfo.setId(race.getId());
        raceInfo.setName(race.getName());
        raceInfo.setType(race.getType());
        raceInfo.setStartTime(race.getStartTime());
        raceInfo.setLocation(locationInfo);

        RiderInfo riderInfo = new RiderInfo();
        riderInfo.setId(raceResult.getRider().getId());
        riderInfo.setName(raceResult.getRider().getName());

        List<RaceInfo> raceInfoList = new ArrayList<>();
        raceInfoList.add(raceInfo);

        List<RiderInfo> riderInfoList = new ArrayList<>();
        riderInfoList.add(riderInfo);

        raceInfo.setRiders(riderInfoList);

        raceResultResponse.setRace(raceInfoList);
        raceResultResponse.setFinishTime(raceResult.getFinishTime());
        raceResultResponse.setFinished(raceResult.isFinished());
        return raceResultResponse;
    }
}
