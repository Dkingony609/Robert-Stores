package com.misprojects.robertssupermarket.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Ibekason Alexander
 *
 */

@Data
@Accessors(chain = true)
@Entity(name = "sales")
public class Sales {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) long id;
    private String customerName;
    @ElementCollection
    private List<String> purchases;
    private String date = new SimpleDateFormat("E, dd MMM yyyy HH:mm").format(new Date());
    private String amount;
    @Enumerated(value = EnumType.STRING)
    private PaymentMethods paymentMethod;
    private String staff;


}
