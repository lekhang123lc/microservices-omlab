package com.hungvi.omlab.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private UserId id;
    private FirstName firstName;
    private LastName lastName;
    private EmailAddress email;

}
