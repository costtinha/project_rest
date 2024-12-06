package com.product.product_rest.Payment;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;

    public PaymentService(PaymentRepository repository, PaymentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public List<PaymentResponseDto> findPayment(){
        return repository.findAll()
                .stream()
                .map(mapper::toPaymentResponseDto)
                .collect(Collectors.toList());
    }

    public PaymentResponseDto savePayment(PaymentDto dto){
        return mapper.toPaymentResponseDto(repository.save(mapper.toPayment(dto)));
    }

    public PaymentResponseDto findPaymentByCheckNum(String CheckNum){
        return mapper.toPaymentResponseDto(repository.findById(CheckNum).orElse(null));
    }

    public List<Payment> findPaymentTotal(){
        return repository.findAll();
    }

    public void deleteByCheckNum(String ck){
        repository.deleteById(ck);
    }

}
