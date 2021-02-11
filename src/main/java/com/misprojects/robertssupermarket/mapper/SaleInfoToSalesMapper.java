package com.misprojects.robertssupermarket.mapper;


import com.misprojects.robertssupermarket.controller.SalesInfoDto;
import com.misprojects.robertssupermarket.model.PaymentMethods;
import com.misprojects.robertssupermarket.model.Sales;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ibekason Alexander
 */

@Slf4j
public class SaleInfoToSalesMapper {

    public static Sales toSales(SalesInfoDto salesInfoDto){

        Sales sales = new Sales()
                .setAmount(salesInfoDto.getAmount())
                .setCustomerName(salesInfoDto.getCustomerName())
                .setPurchases(Stream.of(salesInfoDto.getPurchases().split(",")).collect(Collectors.toList()))
                .setPaymentMethod(PaymentMethods.valueOf(salesInfoDto.getPaymentMethod().toUpperCase()))
                ;
        log.info(sales.toString());
        return sales;

    }

    public static SalesInfoDto toSalesInfoDto(Sales sales){
        return new SalesInfoDto()
                .setAmount(sales.getAmount())
                .setCustomerName(sales.getCustomerName())
                .setDate(sales.getDate())
                .setPurchases(String.join(",", sales.getPurchases()))
                ;
    }
}
