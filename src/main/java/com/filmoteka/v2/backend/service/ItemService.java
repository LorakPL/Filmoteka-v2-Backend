package com.filmoteka.v2.backend.service;

import com.filmoteka.v2.backend.filmwebApi.Caller;
import com.filmoteka.v2.backend.model.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.math.NumberUtils.createInteger;

@Service
public class ItemService {


    @Value("${filmweb-search}")
    private String filmWebSearchLink;

    public ItemService() {
    }

    public  List<Item> getAllItems(String value) {

        List<Item> items = new ArrayList<>();
        List<String> itemDetails;
        String description;
        value = value.replace(" ", "+");
        try {
            String[] contentParts = prepareContent(value).split("\\\\a");

            for (String tmp : contentParts) {
                String[] parts = tmp.split("\\\\c");
                if (parts[0].equals("f") || parts[0].equals("s")) {
                    itemDetails = Caller.getItems("getFilmInfoFull [" + Long.parseLong(parts[1]) + "]", "GET");
                    description = prepareDescription(Caller.getItems("getFilmDescription [" + Long.parseLong(parts[1]) + "]", "GET"));
                    if (parts.length == 7) {
                        items.add(new Item(Long.parseLong(parts[1]), itemDetails.get(1), itemDetails.get(0), preparePhotoUrl(parts[2], "0"),
                                preparePhotoUrl(parts[2], "1"), preparePhotoUrl(parts[2], "2"),
                                preparePhotoUrl(parts[2], "3"), preparePhotoUrl(parts[2], "4"),
                                preparePhotoUrl(parts[2], "5"), preparePhotoUrl(parts[2], "6"),
                                createInteger(parts[6]), null, itemDetails.get(6), itemDetails.get(18),
                                itemDetails.get(4).replace(",", ", "), description, itemDetails.get(19),
                                createInteger(itemDetails.get(17)), createInteger(itemDetails.get(16)), getType(parts[0])));
                    } else {
                        items.add(new Item(Long.parseLong(parts[1]), itemDetails.get(1), itemDetails.get(0), preparePhotoUrl(parts[2], "0"),
                                preparePhotoUrl(parts[2], "1"), preparePhotoUrl(parts[2], "2"),
                                preparePhotoUrl(parts[2], "3"), preparePhotoUrl(parts[2], "4"),
                                preparePhotoUrl(parts[2], "5"), preparePhotoUrl(parts[2], "6"),
                                createInteger(parts[6]), parts[7], itemDetails.get(6), itemDetails.get(18),
                                itemDetails.get(4).replace(",", ", "), description, itemDetails.get(19),
                                createInteger(itemDetails.get(17)), createInteger(itemDetails.get(16)), getType(parts[0])));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }


    private String prepareContent(String value) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(filmWebSearchLink + value);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            while ((inputLine = bufferedReader.readLine()) != null) {
                content.append(inputLine);
            }
            bufferedReader.close();
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private String preparePhotoUrl(String photo, String imageSize) {
        if (photo != null) {
            StringBuilder image = new StringBuilder();
            String[] imageParts;

            imageParts = photo.split("[.]");
            imageParts[imageParts.length - 2] = imageSize;
            image.append("http://1.fwcdn.pl/po").append(imageParts[0]).append(".").append(imageSize).append(".").append("jpg");

            return image.toString();
        }
        return null;
    }

    private String prepareDescription(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String description : list) {
            if (i++ == list.size() - 1) {
                stringBuilder.append(description);
            } else {
                stringBuilder.append(description);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    private static String getType(String type) {
        if (type.equals("f")) {
            return "Movie";
        } else if (type.equals("s")) {
            return "Series";
        }
        return "";
    }
}