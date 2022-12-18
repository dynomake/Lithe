package net.lithe.test;

import net.lithe.Lithe;

public class TestApp {

    public static void main(String[] args) {

        Lithe.scanPackage("net.lithe.test");

        Lithe.get(TestRepository.class).incrementSessions();
        Lithe.get(TestRepository.class).incrementSessions();
        System.out.println(Lithe.get(TestRepository.class).getSessions());

    }
}
