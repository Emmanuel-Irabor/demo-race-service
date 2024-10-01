package com.demo.race.repository.impl;

import com.demo.race.common.Constants;
import com.demo.race.entity.Rider;
import com.demo.race.repository.CustomRaceRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Repository
public class RaceRepositoryImpl implements CustomRaceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Rider> findFastestRidersByRaceId(Long raceId) {
        return entityManager.createQuery(
                        "SELECT rr.rider FROM RaceResult rr WHERE rr.race.id = :raceId ORDER BY rr.finishTime ASC", Rider.class)
                .setParameter("raceId", raceId)
                .setMaxResults(Constants.FASTEST_RIDERS_COUNT)
                .getResultList();
    }

    @Override
    public List<Rider> findRidersWhoDidNotFinishByRaceId(Long raceId) {
        return entityManager.createQuery(
                        "SELECT rr.rider FROM RaceResult rr WHERE rr.race.id = :raceId AND rr.finished = false", Rider.class)
                .setParameter("raceId", raceId)
                .getResultList();
    }

    @Override
    public List<Rider> findRidersNotInRaceByRaceId(Long raceId) {
        return entityManager.createQuery(
                        "SELECT r FROM Rider r WHERE r NOT IN " +
                                "(SELECT rr.rider FROM RaceResult rr WHERE rr.race.id = :raceId)", Rider.class)
                .setParameter("raceId", raceId)
                .getResultList();
    }

}
