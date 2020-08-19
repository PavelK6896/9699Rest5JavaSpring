package rest3.service;


import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Service;
import rest3.dto.Planet;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class PlanetService {

    private static Map<Integer, Planet> planetMap = new HashMap<>();
    private Planet p;

    @PostConstruct
    public void setPlanetMap() {
        planetMap.put(1, new Planet("Mars"));
        planetMap.put(2, new Planet("Mercury"));
        planetMap.put(3, new Planet("Venus"));
        planetMap.put(4, new Planet("Earth"));
        planetMap.put(5, new Planet("Jupiter"));
        planetMap.put(6, new Planet("Saturn"));
        planetMap.put(7, new Planet("Uranus"));
        planetMap.put(8, new Planet("Neptune"));
        planetMap.put(9, new Planet("Pandora"));
        planetMap.put(0, new Planet("Vulcan"));

        p = planetMap.get(RandomUtils.nextInt(planetMap.size()));
    }

    public Planet getPlanetRandom() {
        return planetMap.get(RandomUtils.nextInt(planetMap.size()));
    }

    public Planet getPlanet() {
        return p;
    }


}
