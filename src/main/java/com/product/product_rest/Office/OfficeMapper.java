package com.product.product_rest.Office;

import com.product.product_rest.Employee.Employee;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

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

    public OfficeCache toOfficeCache(Office office){
        OfficeCache officeCache = new OfficeCache();
        officeCache.setCode(office.getCode());
        officeCache.setCity(office.getCity());
        officeCache.setPhone(office.getPhone());
        officeCache.setAddress1(office.getAddress1());
        officeCache.setAddress2(office.getAddress2());
        officeCache.setState(office.getState());
        officeCache.setCountry(office.getCountry());
        officeCache.setPostalCode(office.getPostalCode());
        officeCache.setTerritory(office.getTerritory());
        officeCache.setEmployeesId(office.getEmployees() != null ?
                 office.getEmployees().stream()
                .map(Employee::getEmployeeId)
                .collect(Collectors.toList())
                :Collections.emptyList());
        return officeCache;
    }

    public OfficeResponseDto cachetoResponseDto(OfficeCache cache){
        OfficeResponseDto dto = new OfficeResponseDto(cache.getCity(),
                cache.getPhone(),
                cache.getAddress1(),
                cache.getCountry(),
                cache.getTerritory());
        return dto;
    }
}