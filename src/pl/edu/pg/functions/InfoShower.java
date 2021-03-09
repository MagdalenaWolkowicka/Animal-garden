package pl.edu.pg.functions;

import pl.edu.pg.interfaces.Visible;
import pl.edu.pg.model.Animal;
import pl.edu.pg.model.Owner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InfoShower {

    String information = "Brak danych do wyswietlenia";
    Scanner scanner = new Scanner(System.in);

    public void showOwnerAnimalInfo() {
        InfoShower infoShower = new InfoShower();
        System.out.println("\n1. Informacje o wlascicielach");
        System.out.println("2. Informacje o zwierzętach");
        int userOption = scanner.nextInt();
        if (userOption == 1) {
            infoShower.showInfo(new ArrayList<>(Owner.getOwners()));
        } else if (userOption == 2) {
            infoShower.showInfo(new ArrayList<>(Animal.getAnimals()));
        } else {
            System.out.println("Błędny wybór");
        }
    }

    public void showInfo(List<Visible> visibleList) {
        if (visibleList.isEmpty()) {
            System.out.println(information);
        } else {
            for (Visible visible : visibleList)
                visible.info();
        }
        System.out.println("----------------------------");
    }

    public void showShortInfo(ArrayList<Visible> visibleList) {
        if (visibleList.isEmpty()) {
            System.out.println(information);
        } else {
            for (Visible visible : visibleList) {
                visible.idInfo();
            }
        }
    }

    public void showInfoAYearLater(ArrayList<Visible> visibleList) {
        if (visibleList.isEmpty()) {
            System.out.println(information);
        } else {
            for (Visible visible : visibleList) {
                visible.infoAfterAYear();
            }
        }
        System.out.println("----------------------------");
    }
}