package net.lithe.injectior.implementation;

import lombok.Getter;
import lombok.NonNull;
import net.lithe.injectior.Inject;
import net.lithe.injectior.Injector;
import org.omg.CORBA.portable.RemarshalException;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class RealInjector implements Injector {

    private final Map<Class<?>, Object> singletonMap = new LinkedHashMap<>();
    private final Map<Class<?>, Class<?>> prototypeMap = new LinkedHashMap<>();


    @Override
    public <T> T getInstance(@NonNull Class<T> t) {
        try {
            return singletonMap.containsKey(t) ? (T) singletonMap.get(t) : createInstance(t);
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    @Override
    public void postInitialize() {
        singletonMap.forEach((abstractClass, implementationInstance) -> {

            for (Field field : implementationInstance.getClass().getDeclaredFields()) {
                injectDeclaredField(field, implementationInstance);
            }

        });
    }

    private void injectDeclaredField(@NonNull Field field, @NonNull Object instance) {

        // if field not marked as @Inject
        if (field.getDeclaredAnnotation(Inject.class) == null) return;

        try
        {
            // if type scope == singleton
            if (singletonMap.containsKey(field.getType())) {
                field.setAccessible(true);
                field.set(instance, singletonMap.get(field.getType()));
                return;
            }

            // if type scope == prototype
            if (prototypeMap.containsKey(field.getType())) {
                field.setAccessible(true);
                field.set(instance, createInstance(field.getType()));
            }

        } catch (Exception exception) { throw new RuntimeException(exception); }
    }

    public <T> T createInstance(@NonNull Class<T> tClass) {
        try
        {
            T t = tClass.newInstance();

            for (Field field : tClass.getDeclaredFields()) {
                injectDeclaredField(field, t);
            }

            return t;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
