package com.isa.cm3.delegations;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class DelegationRepository {

    private List<Delegation> list = new ArrayList<>();

    public List<Delegation> getList() {
        return list;
    }

    public  void setList(Delegation delegation) {
        this.list.add(delegation);
    }
}
