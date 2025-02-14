package org.example;
import org.springframework.stereotype.Service;

// Сервис для зоопарка
@Service
public class ZooService {
    private final AnimalRepository animalRepository;
    private final ThingRepository thingRepository;
    private final VetClinicService vetClinicService;

    public ZooService(AnimalRepository animalRepository, ThingRepository inventoryRepository, VetClinicService vetClinicService) {
        this.animalRepository = animalRepository;
        this.thingRepository = inventoryRepository;
        this.vetClinicService = vetClinicService;
    }

    public void addAnimal(Animal animal) {
        if (vetClinicService.checkHealth(animal)) {
            animalRepository.addAnimal(animal);
            System.out.println(animal.toString() + " принято в зоопарк!");
        } else {
            System.out.println(animal.toString() + " не прошло проверку здоровья.");
        }
    }

    public void addThing(Thing thing) {
        thingRepository.addThing(thing);
    }

    public void printFoodReport() {
        int totalFood = animalRepository.getAllAnimals().stream().mapToInt(IAlive::getFood).sum();
        System.out.println("Всего еды требуется: " + totalFood + " кг/день.");
    }

    public void printAnimals() {
        System.out.println("Животные в зоопарке:");
        animalRepository.getAllAnimals()
                .forEach(a -> System.out.println(a.toString()));
    }

    public void printThings() {
        System.out.println("Предметы в зоопарке:");
        thingRepository.getAllInventory()
                .forEach(a -> System.out.println(a.toString()));
    }

    public void printContactZooAnimals() {
        System.out.println("В контактном зоопарке могут быть:");
        animalRepository.getAllAnimals().stream()
                .filter(a -> a instanceof Herbo && ((Herbo) a).getKindness() > 5)
                .forEach(a -> System.out.println(a.toString()));
    }
}
