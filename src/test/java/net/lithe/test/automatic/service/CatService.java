package net.lithe.test.automatic.service;

import net.lithe.injectior.Component;

@Component
public class CatService {
    public void printCat(String line) {
        System.out.println("\uD83E\uDD54 (CAT-SERVICE) | " + line);
    }
}
