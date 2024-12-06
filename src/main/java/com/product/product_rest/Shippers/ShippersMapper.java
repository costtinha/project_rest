package com.product.product_rest.Shippers;

import org.springframework.stereotype.Service;

@Service
public class ShippersMapper {
    public Shippers toShippers(ShippersDto dto){
        return new Shippers(dto.companyName(), dto.phoneNumber());
    }
    public ShippersDto toShippersDto(Shippers shippers){
        return new ShippersDto(shippers.getCompanyName(),shippers.getPhoneNumber());

    }
}
