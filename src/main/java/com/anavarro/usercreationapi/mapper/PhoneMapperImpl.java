package com.anavarro.usercreationapi.mapper;

import com.anavarro.usercreationapi.dto.PhoneDto;
import com.anavarro.usercreationapi.persistence.entities.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapperImpl implements Mapper<PhoneDto, Phone> {

    @Override
    public Phone mapEntity(PhoneDto in) {
        Phone phone = new Phone();
        phone.setPhone(in.getPhone());
        phone.setCityCode(in.getCityCode());
        phone.setCountryCode(in.getCountryCode());
        return phone;
    }

    @Override
    public PhoneDto mapDto(Phone in) {
        return PhoneDto.builder()
                .phone(in.getPhone())
                .cityCode(in.getCityCode())
                .countryCode(in.getCountryCode())
                .build();

    }
}
