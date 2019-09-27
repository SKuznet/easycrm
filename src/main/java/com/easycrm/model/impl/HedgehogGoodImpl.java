package com.easycrm.model.impl;

import com.easycrm.model.Hedgehog;
import org.springframework.stereotype.Component;

@Component("hedgehogGood")
public class HedgehogGoodImpl implements Hedgehog {
    private String name;

    @Override
    public String getName() {
        return "good person";
    }

    public void setName(String name) {
        this.name = name;
    }
}
