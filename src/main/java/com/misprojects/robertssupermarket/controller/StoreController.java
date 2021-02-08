package com.misprojects.robertssupermarket.controller;

import com.misprojects.robertssupermarket.mapper.SaleInfoToSalesMapper;
import com.misprojects.robertssupermarket.model.Sales;
import com.misprojects.robertssupermarket.repository.StoreRepository;
import com.misprojects.robertssupermarket.util.AuthUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
 *  Class controlls the web pages for the sales personnel
 */

@RequiredArgsConstructor
@Slf4j
@Controller
public class StoreController {
    private final StoreRepository storeRepository;
    private final AuthUtils authUtils;


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
        Sales sales = SaleInfoToSalesMapper.toSales(salesInfo)
//                Add the logged in staff after mapping in a non-bean Class
                .setStaff(authUtils.getLoggedUser());

        storeRepository.save(sales);
        return "index";
    }

    @GetMapping("logs")
    public String getLogs(Model model) {
        List<SalesInfoDto> sales = storeRepository.findByStaff(authUtils.getLoggedUser())
                .stream().map(SaleInfoToSalesMapper::toSalesInfoDto)
                .collect(Collectors.toList());

//        Reverse List to sort by date of record save
        Collections.reverse(sales);

        model.addAttribute("sales", sales);
        return "logs";
    }
}
