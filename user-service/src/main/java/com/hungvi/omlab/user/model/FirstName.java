package com.hungvi.omlab.user.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class FirstName {

    private String value;

    @Override
    public String toString() {
        return this.value;
    }
}
