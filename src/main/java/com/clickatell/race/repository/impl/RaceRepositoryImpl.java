package com.clickatell.race.repository.impl;

import com.clickatell.race.common.Constants;
import com.clickatell.race.entity.Race;
import com.clickatell.race.entity.RaceResult;
import com.clickatell.race.entity.Rider;
import com.clickatell.race.repository.CustomRaceRepository;
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
    public List<RaceResult> findFastestByRaceOrderByFinishTimeAsc(Race race) {
        return entityManager.createQuery(
                        "SELECT rr FROM RaceResult rr WHERE rr.race = :race ORDER BY rr.finishTime ASC", RaceResult.class)
                .setParameter("race", race)
                .setMaxResults(Constants.FASTEST_RIDERS_COUNT)
                .getResultList();
    }

    @Override
    public List<RaceResult> findByRaceAndFinishedFalse(Race race) {
        return entityManager.createQuery(
                        "SELECT rr FROM RaceResult rr WHERE rr.race = :race AND rr.finished = false", RaceResult.class)
                .setParameter("race", race)
                .getResultList();
    }

    @Override
    public List<Rider> findRidersNotInRace(Race race) {
        return entityManager.createQuery(
                        "SELECT r FROM Rider r WHERE r NOT IN " +
                                "(SELECT rr.rider FROM RaceResult rr WHERE rr.race = :race)", Rider.class)
                .setParameter("race", race)
                .getResultList();
    }

}
