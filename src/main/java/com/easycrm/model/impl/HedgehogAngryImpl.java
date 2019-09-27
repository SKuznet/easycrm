package com.easycrm.model.impl;

import com.easycrm.model.Hedgehog;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("hedgehogAngry")
public class HedgehogAngryImpl implements Hedgehog {
    private String name;

    @Override
    public String getName() {
        return "Angry person";
    }

    public void setName(String name) {
        this.name = name;
    }
}
