package com.hungvi.omlab.user.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class UserId {

    private Integer value;

    public Integer toInt() {
        return this.value;
    }

}
