package jeonse.insurance;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class HouseInfo {

    private LocalDateTime lastUpdtDt;
    private String aphusSeCodeNm;
    private int pblntfPc;
    private int mortgage;

    public HouseInfo(LocalDateTime lastUpdtDt, String aphusSeCodeNm, int pblntfPc, int mortgage) {
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
