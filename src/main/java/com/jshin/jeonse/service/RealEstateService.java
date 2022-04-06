package com.jshin.jeonse.service;

import com.jshin.jeonse.domain.RealEstate;
import com.jshin.jeonse.domain.RealEstateRepository;
import com.jshin.jeonse.web.dto.HouseDto;
import com.jshin.jeonse.web.dto.RealEstateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RealEstateService {

    private final RealEstateRepository realEstateRepository;

    @Transactional(rollbackFor = Exception.class)
    public void save(RealEstateDto houseDto) {
        realEstateRepository.save(houseDto.toEntity());
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        realEstateRepository.deleteById(id);
    }

}
