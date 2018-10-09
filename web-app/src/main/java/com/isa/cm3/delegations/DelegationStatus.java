package com.isa.cm3.delegations;

public enum DelegationStatus {
    TOACCEPT("do akceptacji"),
    ACCEPTED("akceptacja"),
    DISCARTED("brak zgody");

    private final String message;

    DelegationStatus(String message) {
        this.message = message;
    }

    public String statusType() {
        return message;
    }

}
