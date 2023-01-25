package net.lithe.test.impl;

import net.lithe.test.SessionCounter;

public class MySessionCounter implements SessionCounter {

    private int sessions;

    @Override
    public int getSessions() {
        return sessions;
    }

    @Override
    public void incrementSessions() {
        sessions++;
    }
}
