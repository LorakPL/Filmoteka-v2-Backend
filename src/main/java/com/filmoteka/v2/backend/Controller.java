package com.filmoteka.v2.backend;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/elements")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    @RequestMapping(value="/{value}", method=RequestMethod.GET)
    public ResponseEntity<List<Element>> get(@PathVariable("value") String value) {
        List<Element> elements = new ArrayList<>();
        value = value.replace(" ", "+");
        try {
            URL url = new URL("https://www.filmweb.pl/search/live?q=" + value);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            String[] responseParts = content.toString().split("\\\\a");

            for(String tmp : responseParts) {
                String[] parts = tmp.split("\\\\c");
                if(!parts[0].equals("g")) {
                    if(parts.length == 7) {
                        elements.add(new Element(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], null));
                    } else {
                        elements.add(new Element(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<List<Element>>(elements, new HttpHeaders(), HttpStatus.OK);
    }
}
