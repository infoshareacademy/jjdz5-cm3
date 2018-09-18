package com.isa.cm3.delegations;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DelegationRepository {

    private List<Delegation> list = new ArrayList<>();

    public List<Delegation> getList() {
        return list;
    }

    public  void setList(Delegation delegation) {
        this.list.add(delegation);
    }
}
