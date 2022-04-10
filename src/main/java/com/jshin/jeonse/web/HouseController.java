package com.jshin.jeonse.web;

import com.jshin.jeonse.service.HouseService;
import com.jshin.jeonse.web.dto.HouseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @GetMapping("/")
    public String index(Model model){
        return "search";
    }

    @GetMapping("/jeonse")
    @ResponseBody
    public int findHouse(@RequestParam("pnu") String pnu,
                              @RequestParam("dong") String dong,
                              @RequestParam("ho") String ho) throws Exception {
        //TODO 공시지가 계산 값 전달
        HouseDto houseInfo = houseService.getHouseInfo(pnu, dong, ho);
        return houseService.finJeonseRate(houseInfo);
    }
}
