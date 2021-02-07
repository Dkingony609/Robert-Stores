package com.misprojects.robertssupermarket.controller;

import com.misprojects.robertssupermarket.mapper.SaleInfoToSalesMapper;
import com.misprojects.robertssupermarket.model.Sales;
import com.misprojects.robertssupermarket.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Ibekason Alexander
 *
 */

@RequiredArgsConstructor
@Slf4j
@Controller
public class StoreController {
    private final StoreRepository storeRepository;

    @GetMapping("")
    public String getHome(Model model){
        model.addAttribute("formObject",new SalesInfoDto());
        model.addAttribute("formAction", "save");
        return "index";
    }

    @PostMapping("save")
    public String saveSales(Model model, @ModelAttribute("formObject") SalesInfoDto salesInfo){
        log.info(salesInfo.toString());
//        model.addAttribute("saved", true);
        model.addAttribute("formObject",new SalesInfoDto());
        model.addAttribute("formAction", "save");
        Sales sales = SaleInfoToSalesMapper.toSales(salesInfo);

        storeRepository.save(sales);
        return "index";
    }

    @GetMapping("logs")
    public String getLogs(Model model){
        return "logs";
    }
}
