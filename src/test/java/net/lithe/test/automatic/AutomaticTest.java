package net.lithe.test.automatic;

import net.lithe.Lithe;
import net.lithe.injectior.Injector;
import net.lithe.test.automatic.service.CatService;
import net.lithe.test.old.SessionCounter;
import net.lithe.test.old.TestAdept;

public class AutomaticTest {
    public static void main(String[] args) {
        Injector injector = Lithe.createInjector(new TestAdept());
        injector.getInstance(CatService.class).printCat("Lol, it works!");
    }
}
