package com.product.product_rest.Shippers;

import com.product.product_rest.Persistance.ShippersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShippersService {
    private final ShippersRepository repository;
    private final ShippersMapper mapper;

    public ShippersService(ShippersRepository repository, ShippersMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ShippersDto> findShippers(){
        return repository.findAll()
                .stream()
                .map(mapper::toShippersDto)
                .collect(Collectors.toList());
    }

    public ShippersDto saveShippers(ShippersDto dto){
        return mapper.toShippersDto(repository.save(mapper.toShippers(dto)));
    }

    public ShippersDto findShippersById(int id){
        return mapper.toShippersDto(repository.findById(id).orElse(null));
    }

    public List<Shippers> findShippersTotal(){
        return repository.findAll();
    }

    public void deleteShippersById(int id){
         repository.deleteById(id);
    }


    public List<ShippersDto> findShippersByCompanyName(String companyName) {
        return repository.findShippersByCompanyName(companyName)
                .stream()
                .map(mapper::toShippersDto)
                .collect(Collectors.toList());
    }
}
