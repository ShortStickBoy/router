package com.sunzn.router.sample;

import android.util.Log;

import com.sunzn.router.library.Anchor;
import com.sunzn.router.library.parse.ParserHelp;
import com.sunzn.router.library.parse.ParserRoot;
import com.sunzn.router.library.route.RouterVars;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParserProxy implements ParserRoot<JSONObject> {

    private static ParserProxy instance;

    private ArrayList<String> data;

    static ParserProxy getInstance() {
        if (instance == null) {
            instance = new ParserProxy();
        }
        return instance;
    }

    private ParserProxy() {
        data = new ArrayList<>();
    }

    public void clear() {
        data.clear();
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public String onGetToken(JSONObject value) {
        return ParserHelp.getToken(value);
    }

    @Anchor(parser = RouterVars.Token.AA001)
    public void routHA001(String token, JSONObject value) {
        try {
            data.add(token);
            Log.e("SSSSSSSSSSSSSSSSS", value.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
