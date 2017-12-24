package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:common.properties" , encoding = "utf-8")

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
