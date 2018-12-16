package com.isa.cm3.delegations;

public enum DelegationStatus {
    TOACCEPT("do akceptacji"),
    ACCEPTED("zaakceptowano"),
    DISCARTED("brak akceptacji");

    private final String message;

    DelegationStatus(String message) {
        this.message = message;
    }

    public String statusType() {
        return message;
    }

}
