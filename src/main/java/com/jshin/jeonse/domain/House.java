package com.jshin.jeonse.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;

@Slf4j
@Getter
@NoArgsConstructor
@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime lastUpdtDt;

    private String aphusSeCodeNm;

    private int pblntfPc;

    private int mortgage;

    @OneToOne(mappedBy = "house")
    private RealEstate realEstate;

    @Builder
    public House(LocalDateTime lastUpdtDt, String aphusSeCodeNm, int pblntfPc, int mortgage) {
        this.lastUpdtDt = lastUpdtDt;
        this.aphusSeCodeNm = aphusSeCodeNm;
        this.pblntfPc = pblntfPc;
        this.mortgage = mortgage;
    }


    public int getAvailabilityCondition(int deposit){
        int jeonseRate = calculateJeonseRate(deposit);
        log.info("[HouseInfo] deposit={}, jeonseRate={}",deposit, jeonseRate);
       return jeonseRate;
    }

    private int calculateJeonseRate(int deposit) {
        return deposit - calculateStandardAmount();
    }

    private int calculateStandardAmount(){
        return (int) (this.pblntfPc * 1.5 - this.mortgage);
    }



}
