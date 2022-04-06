package com.jshin.jeonse.web.dto;

import com.jshin.jeonse.domain.House;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class HouseDto {

    private LocalDateTime lastUpdtDt;

    private String aphusSeCodeNm;

    private int pblntfPc;

    private int mortgage;

    @Builder
    public HouseDto(LocalDateTime lastUpdtDt, String aphusSeCodeNm, int pblntfPc, int mortgage) {
        this.lastUpdtDt = lastUpdtDt;
        this.aphusSeCodeNm = aphusSeCodeNm;
        this.pblntfPc = pblntfPc;
        this.mortgage = mortgage;
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
