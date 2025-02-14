package org.example;

import org.springframework.stereotype.Component;
import java.util.Random;
@Component
public class AnimalFactory {

    public Animal createAnimal(String type) {
        switch (type.toLowerCase()) {
            case "monkey":
                return setFood(setKindness(new Monkey()));
            case "rabbit":
                return setFood(setKindness(new Rabbit()));
            case "wolf":
                return setFood(new Wolf());
            case "tiger":
                return setFood(new Tiger());
            default:
                throw new IllegalArgumentException("Неизвестный тип предмета: " + type);
        }
    }
    Animal setFood(Animal animal) {
        animal.setFood(Math.abs(new Random().nextInt() % 10));
        return animal;
    }
    Herbo setKindness(Herbo herbo) {
        herbo.setKindness(new Random().nextInt() % 10);
        return herbo;
    }
}


