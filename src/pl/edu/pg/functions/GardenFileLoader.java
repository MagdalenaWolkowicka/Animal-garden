package pl.edu.pg.functions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GardenFileLoader {

    Scanner scanner = new Scanner(System.in);

    public void loadOwnersAnimals() {
        GardenFileLoader gardenFileLoader = new GardenFileLoader();
        System.out.println("\n1. Odczytaj listę wlascicieli");
        System.out.println("2. Odczytaj listę zwierząt");
        int userOption = scanner.nextInt();
        if (userOption == 1) {
            gardenFileLoader.readFile("Owners.txt");
        } else if (userOption == 2) {
            gardenFileLoader.readFile("Animals.txt");
        } else {
            System.out.println("Błędny wybór");
        }
    }

    public void readFile(String fileName) {

        File file = new File(fileName);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
