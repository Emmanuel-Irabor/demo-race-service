package com.demo.race.entity;

import com.demo.race.common.RaceType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
    @Column(name = "race_id", updatable = false)
    private Long id;

    private String name;

    private String city;

    private BigDecimal latitude;

    private BigDecimal longitude;

    @Enumerated(EnumType.STRING)
    private RaceType type;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @ManyToMany
    @JoinTable(
            name = "race_rider",
            joinColumns = @JoinColumn(name = "race_id"),
            inverseJoinColumns = @JoinColumn(name = "rider_id")
    )
    private List<Rider> riders;
}
