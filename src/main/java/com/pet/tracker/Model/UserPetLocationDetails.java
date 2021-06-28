package com.pet.tracker.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "UserPetLocationDetails")
public class UserPetLocationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "pettagid")
    private Long pettagid;

    @Column(name = "towerId")
    private String towerId;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "locationtimestamp")
    private Timestamp locationtimestamp;
}
