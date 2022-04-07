package com.jshin.jeonse.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jshin.jeonse.web.dto.HouseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HouseApiTest {

    @Autowired
    HouseService houseService;

    @Autowired
    HttpUrLConHouseApi houseApi;

    @Test
    public void houseApiRequest() throws Exception {


        HouseDto houseInfo = houseApi.requestToHouseInfo("1156011400100910000","1","1001");

        assertThat(houseInfo.getDongNm()).isEqualTo("1");
        assertThat(houseInfo.getHoNm()).isEqualTo("1001");
    }

}