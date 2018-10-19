package com.isa.cm3.delegations;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class DelegationRepositoryTest {

    @Test
    void shouldAddDelegation() {

        List<Delegation> delegations = new ArrayList<>();

        LocalDate today = LocalDate.now();

        delegations.add(new Delegation(
                Integer.parseInt("1"),
                LocalDate.parse("2018-10-10"),
                (new Employee(
                            "Tomasz",
                            "Andrzejewski")),
                    today,
                    today,
                    (new Destination(
                            "Poland",
                            "Wrocław",
                            "ABC - xyz",
                            "Władysława III")),
                    "szkolenie",
                    DelegationStatus.TOACCEPT,
                    "Gdańsk",
                    "sadsadsad"));
        }
}