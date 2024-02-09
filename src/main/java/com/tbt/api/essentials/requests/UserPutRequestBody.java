package com.tbt.api.essentials.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserPutRequestBody {

    private Long id;

    @NotEmpty(message = "User name cannot be empty")
    private String name;
}
