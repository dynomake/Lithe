package net.lithe.adept;

import lombok.NonNull;
import net.lithe.Score;
import net.lithe.injectior.Injector;

// TODO: add register with:
//  register(PROTOTYPE, TestRepo.class, () -> return new TestRepo(arguments));
public interface AbstractAdept {

    /**
     * It is needed to initialize all necessary
     * dependencies manually.
     */
    void install();

    /**
     * Register a dependency on the class and its implementation
     * if there is an empty constructor.
     *
     * @param abstractClass - Interface or Abstract class
     * @param implementation - Implementation class of abstractClass
     * @param score - Depend score see(net.lithe.Score), default = singleton
     */
    <T> void register(@NonNull Score score, @NonNull Class<T> abstractClass, @NonNull Class<? extends T> implementation);

    /**
     * Register a singleton dependency on the class and
     * its implementation if there is an empty constructor.
     *
     * @param abstractClass - Interface or Abstract class
     * @param implementation - Implementation class of abstractClass
     */
    default <T> void register(@NonNull Class<T> abstractClass, @NonNull Class<? extends T> implementation) {
        register(Score.SINGLETON, abstractClass, implementation);
    }


    /**
     * Registration of an abstract class and its implementation.
     *
     * @param abstractClass - Interface or Abstract class
     * @param implementationInstance - The instance of the class is the implementation of our abstract class.
     */
    <T> void registerSingleton(@NonNull Class<T> abstractClass, @NonNull T implementationInstance);

    /**
     * Registration of a dependency class with an empty
     * constructor that is not implementing anything.
     *
     * @param tClass - Class the instance we will create.
     * @param score - Depend score see(net.lithe.Score), default = singleton
     */
    <T> void register(@NonNull Score score, @NonNull Class<T> tClass);

    /**
     * Registration of a singleton dependency class with an empty
     * constructor that is not implementing anything.
     *
     * @param tClass - Class the instance we will create.
     */
    default <T> void register(@NonNull Class<T> tClass) {
        register(Score.SINGLETON, tClass);
    }

    /**
     * Registration of singleton instance that we
     * will be able to receive by its class.
     *
     * @param instance - instance
     */
    <T> void registerSingleton(@NonNull T instance);

    /**
     * The required method is used inside the framework,
     * it should not be overridden by you.
     *
     * @return - injector instance
     */
    Injector getInjector();
}
