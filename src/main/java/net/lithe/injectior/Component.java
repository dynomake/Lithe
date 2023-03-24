package net.lithe.injectior;

import net.lithe.Score;

import java.lang.annotation.*;

/**
 * If you use automatic dependency logging, you
 * should put this annotation above the required classes.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {

    Score score() default Score.SINGLETON;
}
