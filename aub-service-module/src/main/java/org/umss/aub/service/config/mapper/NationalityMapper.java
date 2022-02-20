package org.umss.aub.service.config.mapper;


import org.springframework.stereotype.Component;
import org.umss.aub.domain.config.Nationality;
import org.umss.aub.dto.config.NationalityDTO;
import org.umss.aub.service.CustomMapper;

@Component
public class NationalityMapper implements CustomMapper<NationalityDTO, Nationality> {
    @Override
    public NationalityDTO toDto(Nationality nationality) {
        NationalityDTO dto = new NationalityDTO();
        dto.setId(nationality.getId());
        dto.setName(nationality.getName());
        dto.setDemonym(nationality.getDemonym());
        dto.setCode(nationality.getCode());
        return dto;
    }

    @Override
    public Nationality toEntity(NationalityDTO nationalityDTO) {
        Nationality nationality = new Nationality();
        nationality.setId(nationalityDTO.getId());
        nationality.setName(nationalityDTO.getName());
        nationality.setDemonym(nationalityDTO.getDemonym());
        nationality.setCode(nationalityDTO.getCode());
        return nationality;
    }
}
