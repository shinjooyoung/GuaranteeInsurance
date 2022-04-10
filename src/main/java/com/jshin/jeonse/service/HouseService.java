package com.jshin.jeonse.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jshin.jeonse.domain.HouseRepository;
import com.jshin.jeonse.web.dto.HouseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;
    private final HouseApi houseApi;

    @Transactional(rollbackFor = Exception.class)
    public void save(HouseDto houseDto) {
        houseRepository.save(houseDto.toEntity());
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        houseRepository.deleteById(id);
    }

    public HouseDto getHouseInfo(String pnu, String dong, String ho ) throws Exception {
        return houseApi.requestToHouseInfo(pnu, dong, ho);
    }

    public int finJeonseRate(HouseDto houseDto) throws Exception {
        return houseDto.toEntity().getAvailabilityCondition(houseDto.getPblntfPc());
    }

}
