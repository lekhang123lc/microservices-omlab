package com.hungvi.omlab.user.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserUpdateRQ {
    @NotNull
    @JsonProperty(value = "first_name", required = true)
    private String firstName;
    @NotNull
    @JsonProperty(value = "last_name", required = true)
    private String lastName;
    @NotNull
    @JsonProperty(value = "email", required = true)
    private String email;
}
