package wad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Hasukuvapalvelu {

    public static void main(String[] args) {
        SpringApplication.run(Hasukuvapalvelu.class, args);
    }
}
