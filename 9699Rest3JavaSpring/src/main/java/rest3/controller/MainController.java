package rest3.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rest3.dto.Planet;
import rest3.service.PlanetService;

@RestController
public class MainController {
    private PlanetService planetService;

    @Autowired
    public MainController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/q")
    public String mainQ(){
        return "rest 2 main Q";
    }

    @GetMapping("/isAlive")
    public ResponseEntity<?> isAlive(){
        String message = "Testing my healh check function";
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @GetMapping(value = "/pr", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Planet> getPR(){
             return new ResponseEntity<>(planetService.getPlanetRandom(), HttpStatus.OK);
    }

    @GetMapping(value = "/p", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Planet> getP(){
        return new ResponseEntity<>(planetService.getPlanet(), HttpStatus.OK);
    }

}
