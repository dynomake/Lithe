package net.lithe.test.old.impl;

import net.lithe.test.old.PotatoService;

public class MyPotatoService implements PotatoService {

    @Override
    public void printPotato(String line) {
        System.out.println("\uD83E\uDD54 (POTATO-SERVICE) | " + line);
    }
}
