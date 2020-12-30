package com.sunzn.router.library.parse;

import org.json.JSONException;
import org.json.JSONObject;

public class ParserHelp {

    public static String getToken(JSONObject value) {
        try {
            return value.getString("token");
        } catch (JSONException e) {
            return ParserVars.Error.ER002;
        }
    }

}
