package com.jshin.jeonse.service;

import com.jshin.jeonse.domain.HouseRepository;
import com.jshin.jeonse.web.dto.HouseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;

    @Transactional(rollbackFor = Exception.class)
    public void save(HouseDto houseDto) {
       houseRepository.save(houseDto.toEntity());
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        houseRepository.deleteById(id);
    }


}
