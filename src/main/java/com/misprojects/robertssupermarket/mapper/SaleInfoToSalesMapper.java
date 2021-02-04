package com.misprojects.robertssupermarket.mapper;


import com.misprojects.robertssupermarket.controller.SalesInfoDto;
import com.misprojects.robertssupermarket.model.PaymentMethods;
import com.misprojects.robertssupermarket.model.Sales;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

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
                .setStaff(SecurityContextHolder.getContext().getAuthentication().getName());
        log.info(sales.toString());
        return sales;

    }
}
