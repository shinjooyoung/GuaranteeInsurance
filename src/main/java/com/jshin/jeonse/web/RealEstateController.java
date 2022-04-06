package com.jshin.jeonse.web;

import com.jshin.jeonse.service.RealEstateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RealEstateController {

    private final RealEstateService realEstateService;

    /*@PostMapping("/realestate")
    public long save() {

    }*/
}
