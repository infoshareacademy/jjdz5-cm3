package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import java.util.*;
import java.util.stream.Collectors;

@RequestScoped
public class DelegationRepository {

    private List<Delegation> list = new ArrayList<>();

    public List<Delegation> getList() {
        return list;
    }

    public void setList(Delegation delegation) {
        this.list.add(delegation);
    }
}