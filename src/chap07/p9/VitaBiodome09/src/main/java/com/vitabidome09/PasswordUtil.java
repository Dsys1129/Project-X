package com.vitabidome09;

import java.util.Base64;

public final class PasswordUtil {

    public static String decode(String password) {
        return new String(Base64.getDecoder().decode(password));
    }

    public static String encode(String password) {
        return new String(Base64.getEncoder().encode(password.getBytes()));
    }
}
