package com.jshin.jeonse.web.dto;

import com.jshin.jeonse.domain.House;
import com.jshin.jeonse.domain.RealEstate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@ToString
public class RealEstateDto {


    private String numberName;

    private String roadName;

    private String buildingCode;

    private int deposit;

    private String dongNm;

    private String hoNm;

    private House house;


    @Builder
    public RealEstateDto(String numberName, String roadName, String buildingCode, int deposit, String dongNm, String hoNm) {
        this.numberName = numberName;
        this.roadName = roadName;
        this.buildingCode = buildingCode;
        this.deposit = deposit;
        this.dongNm = dongNm;
        this.hoNm = hoNm;
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

    public void setHouse(House house) {
        this.house = house;
    }


}
