package com.misprojects.robertssupermarket.controller;

import lombok.Data;

/**
 * @author Ibekason Alexander
 *
 */
@Data
public class SalesInfoDto {
    private String customerName;
    private String purchases;
    private String amount;
    private String date;
    private String paymentMethod;

}
