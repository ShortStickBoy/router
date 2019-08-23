package com.sunzn.router.library;

import android.content.Intent;
import android.net.Uri;

public class RouterHelp {

    public static String getToken(Uri uri) {
        return uri.getQueryParameter("token");
    }

    public static String getToken(Intent intent) {
        return intent.getStringExtra("token");
    }

}
