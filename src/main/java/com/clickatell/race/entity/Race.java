package com.clickatell.race.entity;

import com.clickatell.race.common.RaceType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Data
@Entity
@Table(name = "race")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    private String name;

    private String location;

    @Enumerated(EnumType.STRING)
    private RaceType type;

    @Column(name = "start_time")
    private LocalDateTime startTime;
}
