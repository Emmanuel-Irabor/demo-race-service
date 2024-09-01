package com.clickatell.race.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Data
@Entity
@Table(name = "race_result")
public class RaceResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Rider rider;

    @ManyToOne
    private Race race;

    @Column(name = "finish_time")
    private BigDecimal finishTime;

    private boolean finished;
}
