package com.sunzn.router.library.parse;

public interface ParserEven {

    void onParserStart(String token);

    void onParserClose(String token);

    void onParserError(String token);

}
