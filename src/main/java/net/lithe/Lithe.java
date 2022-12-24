package net.lithe;

import lombok.NonNull;
import net.lithe.annotation.InitateComponent;
import net.lithe.scanner.AnnotationScanner;
import net.lithe.scanner.ImplementationScanner;

import java.util.HashMap;
import java.util.Map;

public class Lithe {

    private static Map<Class<?>, Object> singletonMap = new HashMap<>();
//    private static Map<Class<?>, Function<Class<?>, Object>> prototypeMap = new HashMap<>();

    public static void scanPackage(@NonNull String packageName) {
        AnnotationScanner.getTypesAnnotatedOf(InitateComponent.class, packageName).forEach(interface1 -> {
            ImplementationScanner.getClassesImplemetationOf(interface1, packageName).forEach(aClass -> {
//                switch (interface1.getDeclaredAnnotation(InitateComponent.class).score()) {
                try {
                    Object o = aClass.newInstance();
                    singletonMap.put(interface1, o);
                    singletonMap.put(aClass, o);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        });
    }

    public static <T> T get(@NonNull Class<T> tClass) {
        T t = (T) singletonMap.get(tClass);
        //(T) prototypeMap.get(tClass).apply(tClass)
        return t;
    }
}
