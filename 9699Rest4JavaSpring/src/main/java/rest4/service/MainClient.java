package rest4.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import rest4.dto.Planet;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MainClient {

    @Autowired
    private DiscoveryClient discoveryClient;


    public List<String> getClient() {

        List<String> rest22 = getStringsClient();
        System.out.println("!!!!!!!!!! " + rest22);

        WebClient client2 = WebClient.create(rest22.get(0));

        WebClient.RequestBodySpec uri1 = client2
                .method(HttpMethod.GET)
                .uri("/q");

        String response3 = uri1
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("}}}}}}}}} " + response3);


        rest22.add(response3);

        return rest22;
    }

    public List<Planet> getPlanet() {

        List<String> rest22 = getStringsClient();
        System.out.println("!!!!!!!!!! " + rest22);
        List<Planet> list = new ArrayList<>();

        rest22.forEach(g -> {
            list.add(WebClient
                    .create(g)
                    .method(HttpMethod.GET)
                    .uri("/p")
                    .retrieve()
                    .bodyToMono(Planet.class)
                    .block());
        });
        System.out.println("!!!!!!!!!! " + list);
        return list;
    }

    private List<String> getStringsClient() {
        return discoveryClient
                .getInstances("rest3")
                .stream()
                .map(ServiceInstance::getUri)
                .map(URI::toString)
                .collect(Collectors.toList());
    }


}
