package com.sunzn.router.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sunzn.router.library.parse.ParserEven;
import com.sunzn.router.library.parse.ParserExec;
import com.sunzn.router.library.route.RouterVars;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RouterExec.route(this, Uri.parse("cnki://wap.cnki.net/cnkiapp.aspx?token=AA001&Type=cjfd&Code=JYDQ20110800"), RouterProxy.getInstance(), new RouterEven() {
//            @Override
//            public void onRouterStart(String token, Context context) {
//                Toast.makeText(context, "onRouterStart", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onRouterClose(String token, Context context) {
//                Toast.makeText(context, "onRouterClose", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onRouterError(String token, Context context) {
//                Toast.makeText(context, token, Toast.LENGTH_SHORT).show();
//            }
//        });

        JSONObject value = new JSONObject();
        try {
            value.put("token", RouterVars.Token.AA001);
            value.put("name", "sunzn");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ParserExec.parse(value, ParserProxy.getInstance(), new ParserEven() {
            @Override
            public void onParserStart(String token) {

            }

            @Override
            public void onParserClose(String token) {

            }

            @Override
            public void onParserError(String token) {

            }
        });
    }
}
