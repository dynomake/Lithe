package net.lithe.scanner;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import net.lithe.annotation.InitateComponent;
import net.lithe.annotation.InitateImplementation;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.stream.Collectors;

@UtilityClass
public class AnnotationScanner {

    public Collection<Class<?>> getTypesAnnotatedOf(@NonNull Class<? extends Annotation> annotation, @NonNull String packageName) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackage(packageName)
                .setScanners(Scanners.Resources, Scanners.TypesAnnotated));
        return reflections.getTypesAnnotatedWith(InitateComponent.class);
    }
}
