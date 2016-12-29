package wad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@EnableAsync
@SpringBootApplication
public class Hasukuvapalvelu {

    public static void main(String[] args) {
        SpringApplication.run(Hasukuvapalvelu.class, args);
    }
}
