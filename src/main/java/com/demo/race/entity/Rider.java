package com.demo.race.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */
@Data
@Entity
@Table(name = "rider")
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rider_id", updatable = false)
    private Long id;

    private String name;
}
