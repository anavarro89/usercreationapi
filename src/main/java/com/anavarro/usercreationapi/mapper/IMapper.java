package com.anavarro.usercreationapi.mapper;

import com.anavarro.usercreationapi.dto.PhoneDto;
import com.anavarro.usercreationapi.persistence.entities.Phone;

public interface IMapper <I,O>{
    public O map(I in);


}
