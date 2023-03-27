package com.anavarro.usercreationapi.mapper;

public interface Mapper <I,O>{
     O mapEntity(I in);
     I mapDto(O in);


}

