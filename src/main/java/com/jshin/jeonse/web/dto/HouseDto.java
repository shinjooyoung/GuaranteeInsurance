package com.jshin.jeonse.web.dto;

import com.jshin.jeonse.domain.House;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class HouseDto {

    private LocalDateTime lastUpdtDt;

    private String aphusSeCodeNm;

    private String dongNm;

    private String hoNm;

    private int pblntfPc;

    private int mortgage;



    @Builder
    public HouseDto(LocalDateTime lastUpdtDt, String aphusSeCodeNm, int pblntfPc, int mortgage, String dongNm, String hoNm) {
        this.lastUpdtDt = lastUpdtDt;
        this.aphusSeCodeNm = aphusSeCodeNm;
        this.pblntfPc = pblntfPc;
        this.mortgage = mortgage;
        this.dongNm = dongNm;
        this.hoNm = hoNm;
    }

    public House toEntity() {
        return House.builder()
                .lastUpdtDt(lastUpdtDt)
                .aphusSeCodeNm(aphusSeCodeNm)
                .pblntfPc(pblntfPc)
                .mortgage(mortgage)
                .build();
    }

}
