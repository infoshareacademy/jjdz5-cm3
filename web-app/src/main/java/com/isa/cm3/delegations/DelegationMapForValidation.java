package com.isa.cm3.delegations;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class DelegationMapForValidation {

    private Map<String, String> parametrMap = new HashMap<>();

    public void setParametrMap(String s1, String s2) {
        this.parametrMap.put(s1, s2);
    }

    public Map<String, String> getParametrMap() {
        return parametrMap;
    }
}
