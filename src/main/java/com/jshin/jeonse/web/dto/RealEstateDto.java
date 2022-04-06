package com.jshin.jeonse.web.dto;

import com.jshin.jeonse.domain.House;
import com.jshin.jeonse.domain.RealEstate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
public class RealEstateDto {


    private String numberName;

    private String roadName;

    private int buildingCode;

    private int deposit;

    private House house;


    @Builder
    public RealEstateDto(String numberName, String roadName, int buildingCode, int deposit, House house) {
        this.numberName = numberName;
        this.roadName = roadName;
        this.buildingCode = buildingCode;
        this.deposit = deposit;
        this.house = house;
    }

    public RealEstate toEntity(){
        return RealEstate.builder()
                .numberName(numberName)
                .roadName(roadName)
                .buildingCode(buildingCode)
                .deposit(deposit)
                .house(house)
                .build();
    }
}
