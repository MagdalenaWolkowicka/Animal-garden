package pl.edu.pg.functions;

import pl.edu.pg.model.Animal;
import pl.edu.pg.model.Turtle;

import java.util.*;

import static pl.edu.pg.model.Animal.getAnimals;

public class AnimalFeeder {

    public void feed() {
        Scanner scanner = new Scanner(System.in);
        InfoShower infoShower = new InfoShower();
        if (Animal.getAnimals().isEmpty()) {
            System.out.println("Brak zwierząt do karmienia");
        } else {
            infoShower.showInfo(new ArrayList<>(Animal.getAnimals()));
            System.out.println("Wpisz numer karmionego zwierzęcia: ");
            int indexNumber = scanner.nextInt();
            for (Animal animal : getAnimals()) {
                if (animal.getType().equals(Animal.Type.TURTLE) && indexNumber == animal.getId()) {
                    System.out.println("Żółw nakarmiony");
                } else if (animal.getType().equals(Animal.Type.CAT) && indexNumber == animal.getId()) {
                    System.out.println("Kot nakarmiony");
                } else if (animal.getType().equals(Animal.Type.DOG) && indexNumber == animal.getId()) {
                    System.out.println("Pies nakarmiony");
                } else {
                    System.out.println("Błędny numer zwierzęcia");
                }
            }
        }
    }
}
