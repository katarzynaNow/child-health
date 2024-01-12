package com.example.childhealth.service;

import com.example.childhealth.dto.ParentProfileDto;
import com.example.childhealth.entity.ParentProfileEntity;
import com.example.childhealth.mappers.ParentProfileMapper;
import com.example.childhealth.repository.ParentProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParentProfileService {

    private final ParentProfileRepository parentProfileRepository;

    private final ParentProfileMapper parentProfileMapper;

    public List<ParentProfileEntity> findAll() {
        return parentProfileRepository.findAll();
    }

    public ParentProfileEntity findById(UUID id) {
        return parentProfileRepository.findById(id).get();
    }

    public void deleteById(UUID id) {
        parentProfileRepository.deleteById(id);
    }

    public ParentProfileEntity saveParentProfileDtoToEntity(ParentProfileDto parentProfileDto){
        ParentProfileEntity parentProfileEntity = parentProfileMapper.dtoToEntity(parentProfileDto);
        return parentProfileRepository.save(parentProfileEntity);
    }
}
