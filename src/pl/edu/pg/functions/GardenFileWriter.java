package pl.edu.pg.functions;

import pl.edu.pg.interfaces.Saveable;
import pl.edu.pg.model.Animal;
import pl.edu.pg.model.Owner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GardenFileWriter {

    Scanner scanner = new Scanner(System.in);

    public void saveOwnersAnimals() {
        GardenFileWriter gardenFileWriter = new GardenFileWriter();
        System.out.println("\n1. Zapisz listę wlascicieli");
        System.out.println("2. Zapisz listę zwierząt");
        int userOption = scanner.nextInt();
        if (userOption == 1) {
            gardenFileWriter.saveList(new ArrayList<>(Owner.getOwners()));
        } else if (userOption == 2) {
            gardenFileWriter.saveList(new ArrayList<>(Animal.getAnimals()));
        } else {
            System.out.println("Błędny wybór");
        }
    }

    public void saveList(ArrayList<Saveable> objectsToSave) {
        if (objectsToSave.isEmpty()) {
            System.out.println("Brak danych do zapisania");
        } else {
            BufferedWriter bw = null;
            try {
                FileWriter fw = new FileWriter(objectsToSave.get(0).getFileNameToSave());
                bw = new BufferedWriter(fw);
                for (Saveable saveable : objectsToSave) {
                    bw.write(saveable.getDataToSave());
                }
            } catch (IOException e) {
                System.out.println("Błąd przy próbie zapisu do pliku " + objectsToSave.get(0).getFileNameToSave());
                e.printStackTrace();
            } finally {
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException e) {
                        System.out.println("Błąd przy próbie zamknięcia pliku " + objectsToSave.get(0).getFileNameToSave());
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}