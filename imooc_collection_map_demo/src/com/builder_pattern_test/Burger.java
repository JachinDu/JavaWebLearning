package com.builder_pattern_test;

public abstract class Burger implements Item {
    public Packing packing()
    {
        return new Wrapper();
    }

    public abstract float price();

}
