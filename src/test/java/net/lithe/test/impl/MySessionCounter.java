package net.lithe.test.impl;

import net.lithe.injectior.Inject;
import net.lithe.test.PotatoService;
import net.lithe.test.SessionCounter;

public class MySessionCounter implements SessionCounter {

    private int sessions = 0;

    @Inject
    private PotatoService potato;

    @Override
    public int getSessions() {
        potato.printPotato("Get sessions void!");
        return sessions;
    }

    @Override
    public void incrementSessions() {
        potato.printPotato("Increment sessions void!");
        sessions++;
    }
}
