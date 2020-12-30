package com.sunzn.router.library.parse;

import com.sunzn.router.library.Anchor;

import java.lang.reflect.Method;

public class ParserExec extends ParserBase {

    public static <V, P extends ParserRoot<V>, E extends ParserEven> void parse(V value, P port, E even) {
        for (Method method : port.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Anchor.class)) {
                try {
                    Anchor anchor = method.getAnnotation(Anchor.class);
                    if (anchor != null) {
                        String parser = anchor.parser();
                        if (port.onGetToken(value).equals(parser)) {
                            onParserStart(parser, even);
                            method.setAccessible(true);
                            method.invoke(port, parser, value);
                            onParserClose(parser, even);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    onParserError(ParserVars.Error.ER002, even);
                }
            }
        }
    }

}
