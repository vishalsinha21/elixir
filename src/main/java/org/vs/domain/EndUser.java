package org.vs.domain;

import java.math.BigInteger;

public class EndUser {

    private BigInteger id;
    private String emailId;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
