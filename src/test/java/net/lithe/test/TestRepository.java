package net.lithe.test;

import net.lithe.annotation.InitateComponent;

@InitateComponent
public interface TestRepository {

    int getSessions();
    void incrementSessions();
}
