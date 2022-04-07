package com.jshin.jeonse.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jshin.jeonse.web.dto.HouseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
@PropertySource("classpath:house.properties")
public class RestTemplateHouseApi implements HouseApi{

    private final Environment env;

    @Override
    public HouseDto requestToHouseInfo(String pnu, String dong, String ho) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        String url = env.getProperty("url");
        String key = env.getProperty("key");

        log.debug("[HTTP API] url={}, key={}", url, key);

        // header
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        //body
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("ServiceKey", key);
        body.add("pnu",pnu);
//        body.add("dongNm",dong);
//        body.add("hoNm",ho);
        body.add("format","json");

        // Combine Message
        HttpEntity<?> requestMessage = new HttpEntity<>(body, httpHeaders);

        // Request and getResponse
        HttpEntity<String> response = restTemplate.postForEntity(url, requestMessage, String.class);

        // Response Body
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        HouseDto dto = objectMapper.readValue(response.getBody(), HouseDto.class);



        return dto;
    }
}
