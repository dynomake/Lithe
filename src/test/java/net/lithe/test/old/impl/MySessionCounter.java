package net.lithe.test.old.impl;

import net.lithe.injectior.Inject;
import net.lithe.test.old.PotatoService;
import net.lithe.test.old.SessionCounter;

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
