package com.product.product_rest.Office;

import org.springframework.stereotype.Service;

@Service
public class OfficeMapper {
    public Office toOffice(OfficeDto dto){
        return new Office(dto.city(), dto.phone(),
                dto.address1(), dto.address2(),
                dto.state(), dto.country(),
                dto.postalCode(), dto.territory());
    }

    public OfficeResponseDto officeResponseDto(Office office){
        return new OfficeResponseDto(office.getCity(), office.getPhone(),
                office.getAddress1(),
                office.getCountry(),
                office.getCountry());
    }
}