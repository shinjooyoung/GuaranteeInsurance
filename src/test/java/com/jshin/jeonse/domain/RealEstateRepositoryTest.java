package com.jshin.jeonse.domain;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RealEstateRepositoryTest {

    @Autowired
    RealEstateRepository realEstateRepository;

    @Autowired
    HouseRepository houseRepository;


 /*   @AfterAll
    public void tearDown() throws Exception{
        realEstateRepository.deleteAll();
    }*/


    @Test
    public void RealEstate_등록한다() {

        realEstateRepository.deleteAll();

        //given
        House house = House.builder()
                .lastUpdtDt(LocalDateTime.now())
                .aphusSeCodeNm("test")
                .pblntfPc(111)
                .mortgage(111)
                .build();

        RealEstate realEstate = RealEstate.builder()
                .numberName("dfd")
                .roadName("dfd")
                .buildingCode("123")
                .deposit(123)
                .house(house)
                .build();
        realEstateRepository.save(realEstate);

        //when
        RealEstate findRealEstate = realEstateRepository.findAll().get(0);



        //then
        assertThat(realEstate.getBuildingCode()).isEqualTo(findRealEstate.getBuildingCode());
        assertThat(realEstate.getHouse().getAphusSeCodeNm()).isEqualTo(house.getAphusSeCodeNm());

        realEstateRepository.deleteAll();
    }

}