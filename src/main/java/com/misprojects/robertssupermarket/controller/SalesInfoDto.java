package com.misprojects.robertssupermarket.controller;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Ibekason Alexander
 *
 */

@Accessors(chain = true)
@Data
public class SalesInfoDto {
    private String customerName;
    private String purchases;
    private String amount;
    private String date;
    private String paymentMethod;

}
