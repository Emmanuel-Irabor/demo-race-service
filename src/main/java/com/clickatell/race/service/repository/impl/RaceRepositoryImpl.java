package com.clickatell.race.service.repository.impl;

import com.clickatell.race.service.entity.Race;
import com.clickatell.race.service.entity.RaceResult;
import com.clickatell.race.service.repository.CustomRaceRepository;
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
    public List<RaceResult> findTop3ByRaceOrderByFinishTimeAsc(Race race) {
        return entityManager.createQuery(
                        "SELECT rr FROM RaceResult rr WHERE rr.race = :race ORDER BY rr.finishTime ASC", RaceResult.class)
                .setParameter("race", race)
                .setMaxResults(3)
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
    public List<RaceResult> findByRace(Race race) {
        return entityManager.createQuery(
                        "SELECT rr FROM RaceResult rr WHERE rr.race = :race", RaceResult.class)
                .setParameter("race", race)
                .getResultList();
    }
}
