Lithe
---
A small framework for getting and creating dependencies. Dependency injection will be implemented in the future.

### `Add as depend:`

| **Gradle:**

```groovy
repositories {
    // other repositories
    maven {
        name = "clojars.org"
        url = uri("https://repo.clojars.org")
    }
}

dependencies {
    // other depends
    implementation 'net.clojars.suuft:lithe:0.9.1'
}
```

| **Maven:**

Repository:

```xml
<repository>
    <id>clojars.org</id>
    <url>https://repo.clojars.org</url>
</repository>
```

Depend:

```xml

<dependency>
    <groupId>net.clojars.suuft</groupId>
    <artifactId>lithe</artifactId>
    <version>0.9.1</version>
</dependency>
```
### `Usage:`
Later..