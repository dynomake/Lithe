package net.lithe.scanner;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import net.lithe.annotation.InitateImplementation;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.util.Collection;
import java.util.stream.Collectors;

@UtilityClass
public class ImplementationScanner {

    public <T> Collection<Class<?>> getClassesImplemetationOf(@NonNull Class<T> tClass, @NonNull String packageName) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackage(packageName)
                .setScanners(Scanners.Resources, Scanners.TypesAnnotated));

        Collection<Class<?>> classes =
                reflections.getTypesAnnotatedWith(InitateImplementation.class).stream().filter(aClass ->
                        tClass.isAssignableFrom(aClass)).collect(Collectors.toList());
        return classes;
    }
}
