package com.clickatell.race.service.repository;

import com.clickatell.race.service.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {}