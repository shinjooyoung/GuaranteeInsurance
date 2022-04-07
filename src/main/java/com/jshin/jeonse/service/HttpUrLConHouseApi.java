package com.jshin.jeonse.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jshin.jeonse.web.dto.HouseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Primary
@Component
@RequiredArgsConstructor
@PropertySource("classpath:house.properties")
public class HttpUrLConHouseApi implements HouseApi{

    private final Environment env;

    @Override
    public HouseDto requestToHouseInfo(String pnu, String dong, String ho) throws Exception  {

        Map<String, Object> resultMap = new HashMap<>();

        String envUrl = env.getProperty("url");
        String key = env.getProperty("key");

        log.debug("[HTTP API] url={}, key={}", envUrl, key);

        StringBuilder urlBuilder = new StringBuilder(envUrl); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+key); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pnu","UTF-8") + "=" + URLEncoder.encode(pnu, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("format","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("dongNm","UTF-8") + "=" + URLEncoder.encode(dong, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("hoNm","UTF-8") + "=" + URLEncoder.encode(ho, "UTF-8"));

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json;charset=UTF-8");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;

        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        ObjectMapper mapper = new ObjectMapper();

        rd.close();
        conn.disconnect();
        return convertMapToHouse(convertJsonStrToMap(sb.toString()));
    }

    private Map<String,Object> convertJsonStrToMap(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
        Map<String, Object> apartHousingPrices = (Map<String, Object>) map.get("apartHousingPrices");
        List<Map<String, Object>> fields = (List<Map<String, Object>>) apartHousingPrices.get("field");
        Map<String, Object> field = null;
        if(fields.size() > 0) {
            field = fields.get(fields.size()-1);
        }
        return field;
    }

    private HouseDto convertMapToHouse(Map<String,Object> map) {
        if(map != null) {
            return HouseDto.builder()
                    .lastUpdtDt(LocalDate.parse(map.get("lastUpdtDt").toString()).atStartOfDay())
                    .aphusSeCodeNm(map.get("aphusSeCodeNm").toString())
                    .dongNm(map.get("dongNm").toString())
                    .hoNm(map.get("hoNm").toString())
                    .pblntfPc(Integer.parseInt(map.get("pblntfPc").toString()))
                    .mortgage(0)
                    .build();
        }
        return null;
    }

    public Map<String,Object> requestToHouseInfo2(String pnu, String dong, String ho) throws Exception  {

        Map<String, Object> resultMap = new HashMap<>();

        String envUrl = env.getProperty("url");
        String key = env.getProperty("key");

        log.debug("[HTTP API] url={}, key={}", envUrl, key);

        StringBuilder urlBuilder = new StringBuilder(envUrl); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+key); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pnu","UTF-8") + "=" + URLEncoder.encode(pnu, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("format","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("dongNm","UTF-8") + "=" + URLEncoder.encode(dong, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("hoNm","UTF-8") + "=" + URLEncoder.encode(ho, "UTF-8"));

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json;charset=UTF-8");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;

        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        ObjectMapper mapper = new ObjectMapper();

        rd.close();
        conn.disconnect();
        return convertJsonStrToMap(sb.toString());
    }

}
