package net.lithe;


import lombok.NonNull;
import net.lithe.annotation.InitateComponent;
import net.lithe.annotation.InitateConstuctor;
import net.lithe.annotation.InitateImplementation;
import net.lithe.scanner.AnnotationScanner;
import net.lithe.scanner.ImplementationScanner;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class Lithe {

    private static Map<Class<?>, Object> singletonMap = new HashMap<>();
    private static Map<Class<?>, Function<Class<?>, Object>> prototypeMap = new HashMap<>();

    public static void scanPackage(@NonNull String packageName) {
        AnnotationScanner.getTypesAnnotatedOf(InitateComponent.class, packageName).forEach(interface1 -> {
            ImplementationScanner.getClassesImplemetationOf(interface1, packageName).forEach(aClass -> {
                switch (interface1.getDeclaredAnnotation(InitateComponent.class).score()) {
                    case PROTOTYPE: {

                        break;
                    }
                    case SINGLETON: {
                        try {
                            Object o = aClass.newInstance();
                            singletonMap.put(interface1, o);
                            singletonMap.put(aClass, o);
                        } catch (InstantiationException e) {
                            throw new RuntimeException(e);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }


                        break;
                    }
                }
            });
        });
    }

    public static <T> T get(@NonNull Class<T> tClass) {
        T t = (T) singletonMap.get(tClass);
        return t == null ? (T) prototypeMap.get(tClass).apply(tClass) : t;
    }
}
