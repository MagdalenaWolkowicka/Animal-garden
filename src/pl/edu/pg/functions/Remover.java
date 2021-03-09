package pl.edu.pg.functions;

import pl.edu.pg.model.Animal;
import pl.edu.pg.model.Owner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Remover {

    Scanner scanner = new Scanner(System.in);
    InfoShower infoShower = new InfoShower();
    String information = "Brak obiektów do usunięcia";

    public void removeLiveBeing() {
        System.out.println("\n1. Usuń wlasciciela");
        System.out.println("2. Usuń zwierze");
        int userOption = scanner.nextInt();
        if (userOption == 1) {
            removeOwner();
        } else if (userOption == 2) {
            removeAnimal();
        } else {
            System.out.println("Błędny wybór");
        }
    }

    public void removeOwner() {
        if (Owner.getOwners().isEmpty()) {
            System.out.println(information);
        } else {
            infoShower.showShortInfo(new ArrayList<>(Owner.getOwners()));
            System.out.println("Wpisz numer usuwanego właściciela: ");
            int indexNumber = scanner.nextInt();
            System.out.println("usuwam właściciela");
            infoShower.showShortInfo(new ArrayList<>(Collections.singleton(Owner.getOwners().remove(indexNumber - 1))));
        }
    }

    public void removeAnimal() {
        if (Animal.getAnimals().isEmpty()) {
            System.out.println(information);
        } else {
            infoShower.showShortInfo(new ArrayList<>(Animal.getAnimals()));
            System.out.println("Wpisz numer usuwanego zwierzęcia: ");
            int indexNumber = scanner.nextInt();
            System.out.println("usuwam zwierzę");
            infoShower.showShortInfo(new ArrayList<>(Collections.singleton(Animal.getAnimals().remove(indexNumber - 1))));
        }
    }
}

