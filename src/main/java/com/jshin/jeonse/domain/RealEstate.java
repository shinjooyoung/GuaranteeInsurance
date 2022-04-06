package com.jshin.jeonse.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class RealEstate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberName;

    private String roadName;

    private int buildingCode;

    private int deposit;


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "house_id")
    private House house;

    @Builder
    public RealEstate(String numberName, String roadName, int buildingCode, int deposit, House house) {
        this.numberName = numberName;
        this.roadName = roadName;
        this.buildingCode = buildingCode;
        this.deposit = deposit;
        this.house = house;
    }

    public int getJeonseRate() {
        return house.getAvailabilityCondition(this.deposit);
    }
}
