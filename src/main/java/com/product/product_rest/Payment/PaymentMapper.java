package com.product.product_rest.Payment;

import com.product.product_rest.Customer.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentDto dto){
        Payment paysaved = new Payment();
        paysaved.setPaymentDate(LocalDateTime.now());
        paysaved.setAmount(dto.amount());
        paysaved.setCheckNum(dto.CheckNum());
        Customer customer = new Customer();
        customer.setId(dto.customerId());
        paysaved.setCustomerId(customer);
        return paysaved;


    }

    public PaymentResponseDto toPaymentResponseDto(Payment pay){
        return new PaymentResponseDto(pay.getCustomerId().getId(),pay.getPaymentDate(),pay.getAmount());
    }
}
