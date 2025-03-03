package com.product.product_rest.Office;

import com.product.product_rest.Cache.OfficeCacheRepository;
import com.product.product_rest.Persistance.OfficeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfficeService {
    private final OfficeRepository repository;
    private final OfficeMapper mapper;
    private final OfficeCacheRepository cacheRepository;

    public OfficeService(OfficeRepository repository, OfficeMapper mapper, OfficeCacheRepository cacheRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.cacheRepository = cacheRepository;
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
        repository.save(office);
        cacheRepository.save(mapper.toOfficeCache(office));
        return mapper.officeResponseDto(office);
    }

    public OfficeResponseDto findById(int id){
        OfficeCache cacheDb = cacheRepository.findById(id).orElse(null);
        if (cacheDb != null){
            System.out.println("Encontrado pelo cache! sucesso");
            return mapper.cachetoResponseDto(cacheDb);
        }
        Office db = repository.findById(id).orElse(null);
        if (db != null){
            cacheRepository.save(mapper.toOfficeCache(db));
            System.out.println("Salvo no cache e vamos que vamos");
            return mapper.officeResponseDto(db);
        }
        return null;
        //return mapper.officeResponseDto(repository.findById(id).orElse(null));
    }

    public List<Office> findOfficeTotal(){
        return repository.findAll();
    }
    public void deleteOffice(int id){
        cacheRepository.deleteById(id);
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
