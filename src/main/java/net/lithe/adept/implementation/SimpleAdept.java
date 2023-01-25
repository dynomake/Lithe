package net.lithe.adept.implementation;

import lombok.Getter;
import lombok.NonNull;
import net.lithe.Score;
import net.lithe.adept.AbstractAdept;
import net.lithe.injectior.Injector;
import net.lithe.injectior.implementation.RealInjector;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public abstract class SimpleAdept implements AbstractAdept {

    // FIXME: this is a bad solution, we need to find a better solution
    private final RealInjector injector = new RealInjector();

    @Override
    public <T> void register(@NonNull Score score, @NonNull Class<T> abstractClass, @NonNull Class<? extends T> implementation) {
        switch (score) {
            case PROTOTYPE -> {
                injector.getPrototypeMap().put(abstractClass, implementation);
                break;
            }
            case SINGLETON -> {
                try {
                    injector.getSingletonMap().put(abstractClass, implementation.newInstance());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }


    @Override
    public <T> void registerSingleton(@NonNull Class<T> abstractClass, @NonNull T implementationInstance) {
        injector.getSingletonMap().put(abstractClass, implementationInstance);
    }

    @Override
    public <T> void register(@NonNull Score score, @NonNull Class<T> tClass) {
        switch (score) {
            case PROTOTYPE -> {
                injector.getPrototypeMap().put(tClass, tClass);
                break;
            }
            case SINGLETON -> {
                try {
                    injector.getSingletonMap().put(tClass, tClass.newInstance());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    @Override
    public <T> void registerSingleton(@NonNull T instance) {
        injector.getSingletonMap().put(instance.getClass(), instance);
    }
}
