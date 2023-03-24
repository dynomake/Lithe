package net.lithe.automatic;

import lombok.NonNull;
import net.lithe.injectior.Component;
import net.lithe.injectior.Injector;
import net.lithe.injectior.implementation.RealInjector;

public class GeneratedInjectorFactory {

    public static Injector createInjector(@NonNull Class<?> c) {
        RealInjector injector = new RealInjector();

        for (Class<?> someClass : AccessingAllClassesInPackage.findAllClassesUsingClassLoader(c.getPackageName())) {
            Component component = someClass.getAnnotation(Component.class);

            if (component != null) {
                switch (component.score()) {
                    case SINGLETON -> {
                        try { injector.getSingletonMap().put(someClass, someClass.newInstance()); }
                        catch (Exception exception) { exception.printStackTrace(); }
                    }
                    case PROTOTYPE -> injector.getPrototypeMap().put(someClass, someClass);
                }
            }

        }

        return injector;
    }

}
