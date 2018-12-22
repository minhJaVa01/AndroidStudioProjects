package com.tintuc.anew.api.base;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class LogginInterceptor implements Interceptor {
    private static final String E_BREAK="%n";
    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
     }
}
