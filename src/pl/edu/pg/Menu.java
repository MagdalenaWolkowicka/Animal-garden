package pl.edu.pg;

import pl.edu.pg.functions.*;
import pl.edu.pg.model.Animal;
import pl.edu.pg.model.Owner;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public enum Options {
        EXIT("Wyjscie"),
        ADD("Dodaj wlasciciela/zwierzę"),
        LIST("Wyświetl informacje o właścicielach/zwierzętach"),
        REMOVE("Usuń właściciela/zwierzę"),
        SAVE("Zapisz listę właścicieli/zwierząt do pliku"),
        LOAD("Odczytaj listę właścicieli/zwierząt z pliku"),
        FEED("Nakarm zwierzę"),
        MOVE_ANIMAL("Rusz zwierzę"),
        YEAR_LATER("Zwierzęta rok później");

        private String value;

        Options(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    Options[] options = Options.values();

    public void showMenu() {
        for (int i = 1; i < options.length; i++) {
            System.out.println(i + ". " + options[i].getValue());
        }
        System.out.println(0 + ". " + Options.EXIT.getValue());
    }

    public void actionMenu() {
        Adder adder = new Adder();
        InfoShower infoShower = new InfoShower();
        GardenFileWriter gardenFileWriter = new GardenFileWriter();
        GardenFileLoader gardenFileLoader = new GardenFileLoader();
        AnimalFeeder animalFeeder = new AnimalFeeder();
        AnimalMover animalMover = new AnimalMover();
        Remover remover = new Remover();

        System.out.println("\nWybierz opcję: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                adder.addLiveBeing();
                break;
            case 2:
                infoShower.showOwnerAnimalInfo();
                break;
            case 3:
                remover.removeLiveBeing();
                break;
            case 4:
                gardenFileWriter.saveOwnersAnimals();
                break;
            case 5:
                gardenFileLoader.loadOwnersAnimals();
                break;
            case 6:
                animalFeeder.feed();
                break;
            case 7:
                animalMover.moveAnimal();
                break;
            case 8:
                infoShower.showInfoAYearLater(new ArrayList<>(Animal.getAnimals()));
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Błędny wybór");
        }
    }
}

