package org.raptor.apis.persistence.execute;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("org.raptor")
@EnableMongoRepositories("org.raptor")
@EntityScan ("org.raptor.apis.persistence.domain.integration.model")
@EnableJpaRepositories("org.raptor")
public class Application {
    public static void main ( String ...a) {
        SpringApplication.run(Application.class);
    }
}
