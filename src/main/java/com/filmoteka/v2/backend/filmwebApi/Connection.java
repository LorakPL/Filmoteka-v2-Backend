package com.filmoteka.v2.backend.filmwebApi;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection implements AutoCloseable {

    private final HttpURLConnection httpURLConnection;

    public Connection(String urlStr, String httpMethod) throws IOException {
        URL url = new URL(urlStr);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(httpMethod);
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        httpURLConnection.connect();
    }

    public InputStream getInputStream() throws IOException {
        return httpURLConnection.getInputStream();
    }

    @Override
    public void close() throws Exception {
        getInputStream().close();
    }
}
