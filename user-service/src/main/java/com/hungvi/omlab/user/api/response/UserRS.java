package com.hungvi.omlab.user.api.response;

import com.hungvi.omlab.user.model.User;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserRS {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public static UserRS of(User _user) {
        return new UserRS()
                .setId(_user.getId().toInt())
                .setFirstName(_user.getFirstName().toString())
                .setLastName(_user.getLastName().toString())
                .setEmail(_user.getEmail().toString());
    }
}
