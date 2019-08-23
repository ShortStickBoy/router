package com.sunzn.router.sample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sunzn.router.library.RouterEven;
import com.sunzn.router.library.RouterExec;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RouterExec.route(this, Uri.parse("cnki://wap.cnki.net/cnkiapp.aspx?token=AA001&Type=cjfd&Code=JYDQ20110800"), RouterProxy.getInstance(), new RouterEven() {
            @Override
            public void onRouterStart(String token, Context context) {
                Toast.makeText(context, "onRouterStart", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRouterClose(String token, Context context) {
                Toast.makeText(context, "onRouterClose", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRouterError(String token, Context context) {
                Toast.makeText(context, token, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
