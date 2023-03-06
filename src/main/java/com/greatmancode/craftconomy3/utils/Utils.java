package com.greatmancode.craftconomy3.utils;

public class Utils {

    public static <T> T requireNonNullElse(T obj, T orElse) {
        return obj == null ? orElse : obj;
    }
}
