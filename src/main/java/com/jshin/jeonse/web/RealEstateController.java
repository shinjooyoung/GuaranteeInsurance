package com.jshin.jeonse.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jshin.jeonse.service.HouseService;
import com.jshin.jeonse.service.RealEstateService;
import com.jshin.jeonse.web.dto.HouseDto;
import com.jshin.jeonse.web.dto.RealEstateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
public class RealEstateController {

    private final RealEstateService realEstateService;
    private final HouseService houseService;

    @PostMapping("/realestate")
    public Long save(@RequestBody RealEstateDto realEstateDto) throws Exception {
        HouseDto houseDto = houseService.getHouseInfo(
                realEstateDto.getBuildingCode(),
                realEstateDto.getDongNm(),
                realEstateDto.getHoNm());
        realEstateDto.setHouse(houseDto.toEntity());
        return realEstateService.save(realEstateDto);
    }
}
