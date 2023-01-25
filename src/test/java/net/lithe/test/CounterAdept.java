package net.lithe.test;

import net.lithe.adept.implementation.SimpleAdept;
import net.lithe.test.impl.MySessionCounter;

public class CounterAdept extends SimpleAdept {
    @Override
    public void install() {
        register(SessionCounter.class, MySessionCounter.class);
    }
}
