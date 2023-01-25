package net.lithe.injectior;

import lombok.NonNull;

// TODO: Auto-Injection to fields, methods, constructor, with: <br>
//  createMethodInjection(UserHelper.class, "getRegisterDate").addArguments("user", user).execute()
//      .parseResult(Date.class);
//
// TODO: For fields:
//  createFieldInjection(user)
//      .injectStatic()
//      .injectInstance()
//      .execute();
public interface Injector {

    /**
     * Getting an instance of the implementation of the specified class. If the type is
     * a prototype, a new instance will be returned.
     *
     * @param t - abstract class.
     * @return - instance of the implementation of the specified class.
     */
    <T> T getInstance(@NonNull Class<T> t);

}
