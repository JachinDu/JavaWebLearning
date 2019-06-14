package com.builder_pattern_test;

public abstract class ColdDrink implements Item {

    public Packing packing()
    {
        return new Bottle();
    }

    public abstract float price();
}
