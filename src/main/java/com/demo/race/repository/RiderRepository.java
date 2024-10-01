package com.demo.race.repository;

import com.demo.race.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {}
