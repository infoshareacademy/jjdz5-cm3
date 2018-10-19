package com.isa.cm3.delegations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelegationStatusTest {


    private String result = "";

    @Test
    @DisplayName("Shuld return \"do akceptacji\" when DelegationStatus is TOACCEPT")
    void ShouldReturnStatusTypeTOACCESS() {
        //arrage
        DelegationStatus choiceStatus = DelegationStatus.TOACCEPT;

        // act
        result = DelegationStatus.TOACCEPT.statusType();

        // assert
        assertEquals("do akceptacji",result);
    }

    @Test
    @DisplayName("Shuld return \"zaakceptowano\" when DelegationStatus is ACCEPTED")
    void ShouldReturnStatusTypeACCEPTED() {
        //arrage
        DelegationStatus choiceStatus = DelegationStatus.ACCEPTED;

        // act
        result = DelegationStatus.ACCEPTED.statusType();

        // assert
        assertEquals("zaakceptowano",result);
    }

    @Test
    @DisplayName("Shuld return \"brak akceptacji\" when DelegationStatus is DISCARTED")
    void ShouldReturnStatusTypeDISCARTED() {
        //arrage
        DelegationStatus choiceStatus = DelegationStatus.DISCARTED;

        // act
        result = DelegationStatus.DISCARTED.statusType();

        // assert
        assertEquals("brak akceptacji",result);
    }
}

