package net.lithe.injectior;

import java.lang.annotation.*;

/**
 * You need to mark this annotation on fields that are registered types.
 * If the field type is not registered, it will be ignored.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
}
