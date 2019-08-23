package com.sunzn.router.library;

import android.content.Context;

class RouterBase {

    static void onRouterStart(String token, RouterEven port, Context context) {
        if (port != null) {
            port.onRouterStart(token, context);
        }
    }

    static void onRouterClose(String token, RouterEven port, Context context) {
        if (port != null) {
            port.onRouterClose(token, context);
        }
    }

    static void onRouterError(String token, RouterEven port, Context context) {
        if (port != null) {
            port.onRouterError(token, context);
        }
    }

}
