package net.lithe.injectior.implementation;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import net.lithe.injectior.Injector;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class RealInjector implements Injector {

    private final Map<Class<?>, Object> singletonMap = new LinkedHashMap<>();
    private final Map<Class<?>, Class<?>> prototypeMap = new LinkedHashMap<>();


    @Override
    public <T> T getInstance(@NonNull Class<T> t) {
        try {
            return singletonMap.containsKey(t) ? (T) singletonMap.get(t) : (T) prototypeMap.get(t).newInstance();
        } catch (Exception e) { throw new RuntimeException(e); }
    }
}
