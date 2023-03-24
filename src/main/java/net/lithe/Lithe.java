package net.lithe;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import net.lithe.adept.AbstractAdept;
import net.lithe.automatic.GeneratedInjectorFactory;
import net.lithe.injectior.Injector;
import net.lithe.injectior.implementation.RealInjector;

@UtilityClass
public class Lithe {

    /**
     * A temporary solution. It is perfect for
     * you if you have one injector in your application.
     */
    @Setter
    @Getter
    private static Injector singletonInjector;

    /**
     * Creating an instance of the Injector class in which there will be dependencies registered in your adept.
     *
     * @param adept - your adept class (different for each platform)
     * @return - injector instance
     */
    public Injector createInjector(@NonNull AbstractAdept adept) {
        adept.install();

        Injector injector = adept.getInjector();

        injector.postInitialize();

        return injector;
    }
    /**
     * Creating an instance of the Injector class, which will
     * have dependencies registered automatically in the class package.
     *
     * @param applicationClass - your main class
     * @return - injector instance
     */
    public Injector createAutomaticInjector(Class<?> applicationClass) {
        Injector injector = GeneratedInjectorFactory.createInjector(applicationClass);

        injector.postInitialize();

        return injector;
    }
}
