package com.tbt.api.essentials.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserPostRequestBody {
    @NotEmpty(message = "User name required")
    private String name;
}
