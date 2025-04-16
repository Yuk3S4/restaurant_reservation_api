package com.edteam.restaurant_reservation.mapper;

import com.edteam.restaurant_reservation.domain.entity.District;
import com.edteam.restaurant_reservation.dto.response.DistrictResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class DistrictMapper {

    private final ModelMapper modelMapper;

    public DistrictResponseDTO toResponseDTO(District district) { // Transformar el district a DistrictResponseDTO mediante el modelMapper
        return modelMapper.map(district, DistrictResponseDTO.class);
    }

    public List<DistrictResponseDTO> toResponseDTOList(List<District> districts) { // Transformar la lista district a lista de DistrictResponseDTO mediante el modelMapper
        return districts.stream()
                .map(this::toResponseDTO)
                .toList();
    }
}
