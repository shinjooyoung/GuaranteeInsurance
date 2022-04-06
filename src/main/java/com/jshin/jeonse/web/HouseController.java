package com.jshin.jeonse.web;

import com.jshin.jeonse.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;

}
