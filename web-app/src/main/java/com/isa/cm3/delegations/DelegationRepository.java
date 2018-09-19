package com.isa.cm3.delegations;

import java.util.ArrayList;
import java.util.List;


public class DelegationRepository {

    public static List<Delegation> list = new ArrayList<>();

    public static List<Delegation> getList() {
        return list;
    }

}
