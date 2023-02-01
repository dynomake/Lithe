package net.lithe.test.impl;

import net.lithe.test.PotatoService;

public class MyPotatoService implements PotatoService {

    @Override
    public void printPotato(String line) {
        System.out.println("\uD83E\uDD54 (POTATO-SERVICE) | " + line);
    }
}
