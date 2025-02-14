package org.example;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ZooService zooService, AnimalFactory animalFactory, ThingFactory thingFactory) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Выберите действие:");
                System.out.println("1 - Добавить животное");
                System.out.println("2 - Добавить предмет");
                System.out.println("3 - Показать отчет по еде");
                System.out.println("4 - Показать животных контактного зоопарка");
                System.out.println("5 - Показать животных");
                System.out.println("6 - Показать инвентарь");
                System.out.println("7 - Выйти");
                System.out.print("Ваш выбор: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Введите тип животного (Tiger, Wolf, Rabbit, Monkey): ");
                        String animalType = scanner.nextLine();
                        try {
                            zooService.addAnimal(animalFactory.createAnimal(animalType));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.print("Введите тип предмета (Table, Computer): ");
                        String thingType = scanner.nextLine();
                        try {
                            zooService.addThing(thingFactory.createThing(thingType));
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        zooService.printFoodReport();
                        break;
                    case 4:
                        zooService.printContactZooAnimals();
                        break;
                    case 5:
                        zooService.printAnimals();
                        break;
                    case 6:
                        zooService.printThings();
                        break;
                    case 7:
                        System.out.println("Выход из программы.");
                        return;
                    default:
                        System.out.println("Неверный выбор, попробуйте снова.");
                }
            }
        };
    }
}
