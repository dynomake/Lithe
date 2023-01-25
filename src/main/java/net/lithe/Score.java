package net.lithe;

public enum Score {
    /**
     * If the implementation should have only one instance.
     */
    SINGLETON,
    /**
     * If a new instance must be created each
     * time to get an implementation.
     */
    PROTOTYPE
}