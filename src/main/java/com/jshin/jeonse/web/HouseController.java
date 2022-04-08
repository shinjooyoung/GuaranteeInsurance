package com.jshin.jeonse.web;

import com.jshin.jeonse.service.HouseService;
import com.jshin.jeonse.web.dto.HouseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;



}
