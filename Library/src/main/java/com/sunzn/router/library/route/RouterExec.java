package com.sunzn.router.library.route;

import android.content.Context;

import com.sunzn.router.library.Anchor;

import java.lang.reflect.Method;

public class RouterExec extends RouterBase {

    public static <V, P extends RouterRoot<V>, E extends RouterEven> void route(Context context, V value, P port, E even) {
        for (Method method : port.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Anchor.class)) {
                try {
                    Anchor anchor = method.getAnnotation(Anchor.class);
                    if (anchor != null) {
                        String router = anchor.router();
                        if (port.onGetToken(value).equals(router)) {
                            onRouterStart(router, even, context);
                            method.setAccessible(true);
                            method.invoke(port, router, value, context);
                            onRouterClose(router, even, context);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    onRouterError(RouterVars.Error.ER002, even, context);
                }
            }
        }
        onRouterError(RouterVars.Error.ER001, even, context);
    }

}
