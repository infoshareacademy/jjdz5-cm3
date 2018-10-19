package com.isa.cm3.delegations;

import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.*;

import static org.junit.Assert.*;

class DelegationFilterTest {

    @Inject
    private DelegationFilter delegationFilter;

    @Test
    void ShouldReturnNullWhenDataInvalid() {

        // arrage
        String choiceCreationDate = "2018-10-08";
        String choiceName = "Paweł";
        String choiceSurname = "Gaweł";
        String choiceCountry = "Poland";
        DelegationStatus choiceStatus = DelegationStatus.TOACCEPT;

        // act
        Optional<List<Delegation>> result = null;
        try {
            result = Optional.ofNullable(delegationFilter.getFilteredList(choiceCreationDate, choiceName, choiceSurname, choiceCountry, choiceStatus));
        } catch (Exception e) {}
        // assert

        assertNull(result);
    }
}