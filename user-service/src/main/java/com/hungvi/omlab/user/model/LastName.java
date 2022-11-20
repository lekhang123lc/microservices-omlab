package com.hungvi.omlab.user.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class LastName {

    private String value;

    @Override
    public String toString() {
        return this.value;
    }
}
