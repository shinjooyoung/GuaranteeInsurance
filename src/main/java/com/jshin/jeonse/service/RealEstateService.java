package com.jshin.jeonse.service;

import com.jshin.jeonse.domain.RealEstateRepository;
import com.jshin.jeonse.web.dto.RealEstateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RealEstateService {

    private final RealEstateRepository realEstateRepository;

    @Transactional(rollbackFor = Exception.class)
    public Long save(RealEstateDto realEstateDto) {
        return realEstateRepository.save(realEstateDto.toEntity()).getId();
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        realEstateRepository.deleteById(id);
    }

}
