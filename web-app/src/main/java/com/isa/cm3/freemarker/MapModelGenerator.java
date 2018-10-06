package com.isa.cm3.freemarker;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class MapModelGenerator {

    private Map<String, Object> model = new HashMap<>();

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(String s, Object o) {
        this.model.put(s, o);
    }

}
