package net.lithe.test.impl;

import net.lithe.annotation.InitateImplementation;
import net.lithe.test.TestRepository;

@InitateImplementation
public class TestRepositoryImpl implements TestRepository {

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
