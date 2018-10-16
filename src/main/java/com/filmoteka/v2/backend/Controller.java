package com.filmoteka.v2.backend;

import com.filmoteka.v2.backend.model.Item;
import com.filmoteka.v2.backend.service.ItemService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Api(value = "/", description = "Filmweb API operations")
public class Controller {
    @RequestMapping(value="getAllItems/{value}", method=RequestMethod.GET)
    public ResponseEntity<List<Item>> getItems(@PathVariable("value") String value) {
        List<Item> elements = ItemService.getAllItems(value);
        return new ResponseEntity<>(elements, new HttpHeaders(), HttpStatus.OK);
    }
}
