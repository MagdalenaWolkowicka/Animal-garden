package pl.edu.pg.functions;

import pl.edu.pg.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Adder {

    ArrayList<Owner> owners = new ArrayList<>();
    private List<Animal> ownerAnimals = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    InfoShower infoShower = new InfoShower();
    String gender = null;
    String animalName;
    int animalAge;
    int ownerNumber;

    public void addLiveBeing() {

        System.out.println("\n1. Dodaj wlasciciela");
        System.out.println("2. Dodaj zwierze");
        int userOption = scanner.nextInt();
        if (userOption == 1) {
            addOwner();
        } else if (userOption == 2) {
            addAnimal();
        } else {
            System.out.println("Błędny wybór");
        }
    }

    public void addOwner() {
        String name = null;
        String surname = null;
        int age = 0;

        for (int i = 0; i < 20; i++) {
            System.out.println("Podaj imię: ");
            name = scanner.next();
            System.out.println("Podaj nazwisko: ");
            surname = scanner.next();
            System.out.println("Podaj wiek: ");
            age = scanner.nextInt();
            System.out.println("Podaj płeć: 1 - męska, 2 - damska");
            gender = scanner.next();

            for (int j = 0; j < 10; j++) {
                System.out.println("Koniec 1, Kolejny właściciel 2");
                int genderChoice = scanner.nextInt();
                if (genderChoice == 1) {
                    if (gender.equals("1")) {
                        gender = "męska";
                    } else if (gender.equals("2")) {
                        gender = "żeńska";
                    }
                    owners.add(new Owner(name, surname, age, gender));
                    System.out.println("Właściciele dodani");
                    infoShower.showInfo(new ArrayList<>(Owner.getOwners()));
                    return;
                } else if (genderChoice == 2) {
                    owners.add(new Owner(name, surname, age, gender));
                    break;
                } else {
                    System.out.println("Błędny wybór");
                }
            }
        }
    }

    private void addCat() {
        String animalBreed = null;
        addBasicAnimalInfo();
        System.out.println("Podaj rasę: ");
        animalBreed = scanner.nextLine();
        chooseGender();
        Owner.getOwnerAnimals().add(new Cat(animalName, animalAge, animalBreed, gender, ownerNumber));
        System.out.println("Kot dodany");
        infoShower.showInfo(new ArrayList<>(Animal.getAnimals()));
    }

    private void addDog() {
        String animalBreed;
        addBasicAnimalInfo();
        System.out.println("Podaj rasę: ");
        animalBreed = scanner.nextLine();
        chooseGender();
        Owner.getOwnerAnimals().add(new Dog(animalName, animalAge, animalBreed, gender, ownerNumber));
        System.out.println("Pies dodany");
        infoShower.showInfo(new ArrayList<>(Animal.getAnimals()));
    }

    private void addTurtle() {
        addBasicAnimalInfo();
        chooseGender();
        Owner.getOwnerAnimals().add(new Turtle(animalName, animalAge, true, gender, ownerNumber));
        System.out.println("Żółw dodany");
        infoShower.showInfo(new ArrayList<>(Animal.getAnimals()));
    }

    public void addAnimal() {
        if (Owner.getOwners().isEmpty()) {
            System.out.println("Zeby dodac zwierze musisz najpierw dodac wlasciciela.");
        } else {
            infoShower.showInfo(new ArrayList<>(Owner.getOwners()));
            System.out.println("Podaj numer właściciela, któremu chcesz dodać zwierze: ");
            ownerNumber = scanner.nextInt();
            if (ownerNumber >= Owner.getOwners().size() + 1 || ownerNumber < 0) {
                System.out.println("Brak właściciela o tym numerze");
            } else {
                System.out.println("Wybierz gatunek: 1 - kot, 2 - pies, 3 - żółw");
                int type = scanner.nextInt();
                if (type == 1) {
                    addCat();
                }
                if (type == 2) {
                    addDog();
                }
                if (type == 3) {
                    addTurtle();
                }
            }
        }
    }

    public void chooseGender() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Podaj płeć: 1 - męska, 2 - damska");
            gender = scanner.next();
            if (gender.equals("1")) {
                gender = "męska";
                break;
            } else if (gender.equals("2")) {
                gender = "żeńska";
                break;
            }
        }
    }

    public void addBasicAnimalInfo() {
        System.out.print("Podaj imie: ");
        animalName = scanner.next();
        System.out.print("Podaj wiek: ");
        animalAge = scanner.nextInt();
        scanner.nextLine();
    }
}