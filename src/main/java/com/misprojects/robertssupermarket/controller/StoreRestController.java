package com.misprojects.robertssupermarket.controller;

import com.misprojects.robertssupermarket.model.PaymentMethods;
import com.misprojects.robertssupermarket.model.Sales;
import com.misprojects.robertssupermarket.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/sales")
public class StoreRestController {

    private final StoreRepository storeRepository;


    @GetMapping("")
    public List<Sales> getAllSales() {
        return storeRepository.findAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteSales(@PathVariable("id") long id) {
        storeRepository.findById(id).ifPresent(storeRepository::delete);
        return ResponseEntity.ok(null);
    }

    @GetMapping("{id}")
    public Sales getSaleByID(@PathVariable long id) {
        return storeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @PatchMapping("{id}")
    public Sales updateSales(@PathVariable("id") long id, @RequestBody SalesInfoDto salesInfoDto) {
        Sales sales = storeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        sales.setAmount(salesInfoDto.getAmount())
                .setPaymentMethod(PaymentMethods.valueOf(salesInfoDto.getPaymentMethod().toUpperCase()))
                .setCustomerName(salesInfoDto.getCustomerName())
                .setPurchases(Stream.of(salesInfoDto.getPurchases().split(",")).collect(Collectors.toList()));
        return storeRepository.save(sales);

    }

    @GetMapping("staff")
    public List<Sales> getSalesByStaff(@RequestParam("name") String name) {
        return storeRepository.findByStaff(name.toLowerCase());
    }


}
