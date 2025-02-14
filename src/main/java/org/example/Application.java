package org.example;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ZooService zooService) {
        return args -> {

            zooService.addAnimal(new Tiger());
            zooService.addAnimal(new Rabbit());
            zooService.addAnimal(new Monkey());
            zooService.printFoodReport();
            zooService.printContactZooAnimals();
        };
    }
}
