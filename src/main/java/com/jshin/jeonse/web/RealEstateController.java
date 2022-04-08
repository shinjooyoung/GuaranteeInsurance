package com.jshin.jeonse.web;

import com.jshin.jeonse.service.HouseService;
import com.jshin.jeonse.service.RealEstateService;
import com.jshin.jeonse.web.dto.HouseDto;
import com.jshin.jeonse.web.dto.RealEstateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class RealEstateController {

    private final RealEstateService realEstateService;
    private final HouseService houseService;

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @ResponseBody
    @GetMapping("/realestate")
    public String find(Model model){
        //TODO 크롤링으로 매물 정보 가져오는 서비스
//        model.addAllAttributes("realestate", realEstateService.findAllDesc());
        return "index";
    }

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
