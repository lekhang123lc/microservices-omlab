package com.hungvi.omlab.user.model;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode
public class EmailAddress {
    @javax.validation.constraints.Email
    @NonNull
    private final String value;

    private EmailAddress(String _email) {
        this.value = _email;
    }

    public static EmailAddress of(@NonNull String _email) {
        return new EmailAddress(_email.toLowerCase());
    }

    public static EmailAddress of(@NonNull String _localPart, @NonNull String _domainPart) {
        return new EmailAddress(_localPart.toLowerCase() + "@" + _domainPart.toLowerCase());
    }

    public static EmailAddress ofNullable(String _email) {
        if (_email != null) {
            return new EmailAddress(_email.toLowerCase());
        } else {
            return new EmailAddress(null);
        }
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String getLocalPart() {
        return StringUtils.split(this.value, "@", 2)[0];
    }

    public String getDomainPart() {
        return StringUtils.split(this.value, "@", 2)[1];
    }

}
