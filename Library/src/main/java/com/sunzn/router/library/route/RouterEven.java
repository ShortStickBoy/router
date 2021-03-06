package com.sunzn.router.library.route;

import android.content.Context;

public interface RouterEven {

    void onRouterStart(String token, Context context);

    void onRouterClose(String token, Context context);

    void onRouterError(String token, Context context);

}
