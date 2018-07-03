package com.filmoteka.v2.backend.filmwebApi;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Caller {

    public static <T> T getItems(String method, String httpMethod) {

        String params = prepareParams(method);
        if (params == null) {
            return null;
        }

        StringBuilder html = new StringBuilder();
        try (
                Connection connection = new Connection("https://ssl.filmweb.pl/api?" + params, httpMethod);
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

            String str;
            String stateStr = br.readLine();
            while ((str = br.readLine()) != null) {
                html.append(str);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return analyze(html.toString());
    }

    private static String prepareParams(String method) {

        String signature = prepareSignature(method);
        method += "\\n";

        String qs;
        try {
            qs = "methods=" + URLEncoder.encode(method, "UTF-8");
            qs += "&signature=" + URLEncoder.encode(signature, "UTF-8");
            qs += "&version=" + URLEncoder.encode("1.0", "UTF-8");
            qs += "&appId=" + URLEncoder.encode("android", "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return qs;
    }

    private static String prepareSignature(String method) {
        String signature = method + "\\n" + "android" + "qjcGhW2JnvGT9dfCt3uT_jozR3s";
        signature = "1.0" + "," + DigestUtils.md5Hex(signature);
        return signature;
    }

    private static <T> T analyze(String response) {
        JsonStreamParser parser = new JsonStreamParser(response);
        if (parser.hasNext()) {
            JsonElement reposnse = parser.next();
            return getData(reposnse);
        }
        return null;
    }

    private static <T> T getData(JsonElement element) {
        if (element.isJsonNull()) return null;
        else if (element.isJsonArray()) {
            List<T> data = new ArrayList<>();
            JsonArray ja = element.getAsJsonArray();
            for (JsonElement e : ja) {
                data.add((T) getData(e));
            }
            return (T) data;
        }
        else return (T) element.getAsString();
    }
}
