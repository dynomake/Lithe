package net.lithe.test.old;

import net.lithe.adept.implementation.SimpleAdept;
import net.lithe.test.old.impl.MyPotatoService;
import net.lithe.test.old.impl.MySessionCounter;

public class TestAdept extends SimpleAdept {
    @Override
    public void install() {
        register(SessionCounter.class, MySessionCounter.class);
        register(PotatoService.class, MyPotatoService.class);
    }
}
