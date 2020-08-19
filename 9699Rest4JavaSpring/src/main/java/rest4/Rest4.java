package rest4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class Rest4 {
    public static void main(String[] args) {
        SpringApplication.run(Rest4.class, args);
    }
}
