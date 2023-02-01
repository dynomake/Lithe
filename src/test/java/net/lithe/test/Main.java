package net.lithe.test;

import net.lithe.Lithe;
import net.lithe.injectior.Injector;

public class Main {

    public static void main(String[] args) {
        Injector injector = Lithe.createInjector(new TestAdept());
        System.out.println("Current sessions: " + injector.getInstance(SessionCounter.class).getSessions());

        System.out.println("Try increment #1");
        injector.getInstance(SessionCounter.class).incrementSessions();

        System.out.println("Try increment #2");
        injector.getInstance(SessionCounter.class).incrementSessions();

        System.out.println("Current sessions: " + injector.getInstance(SessionCounter.class).getSessions());
    }
}
