package com.clickatell.race.service.repository;

import com.clickatell.race.service.entity.Race;
import com.clickatell.race.service.entity.RaceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Repository
public interface RaceResultRepository extends JpaRepository<RaceResult, Long> {}
