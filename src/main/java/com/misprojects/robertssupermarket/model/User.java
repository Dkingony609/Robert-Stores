package com.misprojects.robertssupermarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

/**
 * @author Ibekason ALexander
 */

@Accessors(chain = true)
@Data
@Entity
@Table(name = "users")
public class User {
    @JsonIgnore
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "staff")
    private List<Sales> sales;
}
