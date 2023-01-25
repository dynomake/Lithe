package net.lithe;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import net.lithe.adept.AbstractAdept;
import net.lithe.injectior.Injector;
import net.lithe.injectior.implementation.RealInjector;

@UtilityClass
public class Lithe {

    /**
     * Creating an instance of the Injector class in which there will be dependencies registered in your adept.
     *
     * @param adept - your adept class (different for each platform)
     * @return - injector instance
     */
    public Injector createInjector(@NonNull AbstractAdept adept) {
        adept.install();
        return adept.getInjector();
    }

}
