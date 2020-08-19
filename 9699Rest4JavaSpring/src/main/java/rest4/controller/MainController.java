package rest4.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rest4.dto.Planet;
import rest4.service.MainClient;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private MainClient mainClient;


    @GetMapping("/q")
    public List<String> mainQ(){
        return mainClient.getClient();
    }

    @GetMapping("/p")
    public List<Planet> mainP(){
        return mainClient.getPlanet();
    }

    @GetMapping("/isAlive")
    public ResponseEntity<?> isAlive(){
        String message = "Testing my healh check function";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }




}
