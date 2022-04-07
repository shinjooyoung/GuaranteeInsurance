package com.jshin.jeonse.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jshin.jeonse.web.dto.HouseDto;

public interface HouseApi {

    HouseDto requestToHouseInfo(String pnu, String dong, String ho) throws Exception;

}
