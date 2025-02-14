package org.example;
import org.springframework.stereotype.Service;
import java.util.Random;

// Сервис для зоопарка
@Service
public class ZooService {
    private final AnimalRepository animalRepository;
    private final InventoryRepository inventoryRepository;
    private final VetClinicService vetClinicService;

    public ZooService(AnimalRepository animalRepository, InventoryRepository inventoryRepository, VetClinicService vetClinicService) {
        this.animalRepository = animalRepository;
        this.inventoryRepository = inventoryRepository;
        this.vetClinicService = vetClinicService;
    }

    public void addAnimal(Animal animal) {
        if (vetClinicService.checkHealth(animal)) {
            animalRepository.addAnimal(animal);
            inventoryRepository.addInventoryItem(animal);
            System.out.println(animal.toString() + " принято в зоопарк!");
        } else {
            System.out.println(animal.toString() + " не прошло проверку здоровья.");
        }
    }

    public void addInventory(Thing thing) {
        inventoryRepository.addInventoryItem(thing);
    }

    public void printFoodReport() {
        int totalFood = animalRepository.getAllAnimals().stream().mapToInt(IAlive::getFood).sum();
        System.out.println("Всего еды требуется: " + totalFood + " кг/день.");
    }

    public void printContactZooAnimals() {
        animalRepository.getAllAnimals().stream()
                .filter(a -> a instanceof Herbo && ((Herbo) a).getKindness() > 5)
                .forEach(a -> System.out.println(a.toString() + " может быть в контактном зоопарке"));
    }
}
