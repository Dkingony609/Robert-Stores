package com.misprojects.robertssupermarket.controller;

import com.misprojects.robertssupermarket.mapper.SaleInfoToSalesMapper;
import com.misprojects.robertssupermarket.model.Sales;
import com.misprojects.robertssupermarket.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ibekason Alexander
 */

@RequiredArgsConstructor
@Slf4j
@Controller
public class StoreController {
    private final StoreRepository storeRepository;

    @GetMapping("")
    public String getHome(Model model) {
        model.addAttribute("formObject", new SalesInfoDto());
        model.addAttribute("formAction", "save");
        return "index";
    }

    @PostMapping("save")
    public String saveSales(Model model, @ModelAttribute("formObject") SalesInfoDto salesInfo) {
        model.addAttribute("saved", true);
        model.addAttribute("formObject", new SalesInfoDto());
        model.addAttribute("formAction", "save");
        Sales sales = SaleInfoToSalesMapper.toSales(salesInfo);

        storeRepository.save(sales);
        return "index";
    }

    @GetMapping("logs")
    public String getLogs(Model model) {
        String loggedUser = SecurityContextHolder.getContext().getAuthentication().getName();
        List<SalesInfoDto> sales = storeRepository.findByStaff(loggedUser.toLowerCase())
                .stream().map(SaleInfoToSalesMapper::toSalesInfoDto)
                .collect(Collectors.toList());
        Collections.reverse(sales);
        model.addAttribute("sales", sales);
        return "logs";
    }
}
