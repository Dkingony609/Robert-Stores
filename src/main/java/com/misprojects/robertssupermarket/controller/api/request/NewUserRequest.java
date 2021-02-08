package com.misprojects.robertssupermarket.controller.api.request;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author Ibekason Alexander Onyebuchi
 */

@Data
@Accessors(chain = true)
public class NewUserRequest {
    @NotEmpty
    private String username;
    @NotEmpty
    @Size(min = 4)
    private String password;
}
