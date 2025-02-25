package com.product.product_rest.Office;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficeService {
    private final OfficeRepository repository;
    private final OfficeMapper mapper;

    public OfficeService(OfficeRepository repository, OfficeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<OfficeResponseDto> findOffice(){
        return repository.findAll()
                .stream()
                .map(mapper::officeResponseDto)
                .collect(Collectors.toList());
    }

    public OfficeResponseDto saveOffice(
            OfficeDto dto
    ){
        Office office = mapper.toOffice(dto);
        return mapper.officeResponseDto(repository.save(office));
    }

    public OfficeResponseDto findById(int id){
        return mapper.officeResponseDto(repository.findById(id).orElse(null));
    }

    public List<Office> findOfficeTotal(){
        return repository.findAll();
    }
    public void deleteOffice(int id){
        repository.deleteById(id);
    }


    public List<OfficeResponseDto> findOfficeByName(String city) {
        return repository.findOfficeByCity(city)
                .stream()
                .map(mapper::officeResponseDto)
                .collect(Collectors.toList());
    }

    public List<OfficeResponseDto> findOfficeByState(String state) {
        return repository.findOfficeByState(state)
                .stream()
                .map(mapper::officeResponseDto)
                .collect(Collectors.toList());
    }

    public List<OfficeResponseDto> findOfficeByCountry(String country) {
        return repository.findOfficeByCountry(country)
                .stream()
                .map(mapper::officeResponseDto)
                .collect(Collectors.toList());
    }
}
