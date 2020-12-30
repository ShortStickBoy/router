package com.sunzn.router.library.parse;

public class ParserBase {

    static void onParserStart(String token, ParserEven port) {
        if (port != null) {
            port.onParserStart(token);
        }
    }

    static void onParserClose(String token, ParserEven port) {
        if (port != null) {
            port.onParserClose(token);
        }
    }

    static void onParserError(String token, ParserEven port) {
        if (port != null) {
            port.onParserError(token);
        }
    }

}
