package com.sunzn.router.sample;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

import com.sunzn.router.library.Anchor;
import com.sunzn.router.library.route.RouterHelp;
import com.sunzn.router.library.route.RouterRoot;
import com.sunzn.router.library.route.RouterVars;

public class RouterProxy implements RouterRoot<Uri> {

    private static RouterProxy instance;

    static RouterProxy getInstance() {
        if (instance == null) {
            instance = new RouterProxy();
        }
        return instance;
    }

    @Override
    public String onGetToken(Uri value) {
        return RouterHelp.getToken(value);
    }

    @Anchor(router = RouterVars.Token.AA001)
    public void routHA001(String token, Uri value, Context context) {
        Toast.makeText(context, RouterVars.Token.AA001, Toast.LENGTH_SHORT).show();
    }

}
