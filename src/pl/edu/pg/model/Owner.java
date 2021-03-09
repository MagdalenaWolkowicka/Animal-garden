package pl.edu.pg.model;

import pl.edu.pg.functions.InfoShower;
import pl.edu.pg.interfaces.Saveable;
import pl.edu.pg.interfaces.Visible;

import java.util.ArrayList;
import java.util.List;

public class Owner extends LiveBeing implements Visible, Saveable {

    //------------------- pola ----------------------------------

    private static int personCount = 0;
    public String surname;
    private static List<Owner> owners = new ArrayList<>();
    private static List<Animal> ownerAnimals = new ArrayList<>();

    //------------------- metody ---------------------------------

    public Owner(String name, String surname, int age, String gender) {
        super(name, age);
        this.surname = surname;
        this.id = ++personCount;
        owners.add(this);
        this.gender = gender;
    }

    @Override
    public void info() {
        InfoShower infoShower = new InfoShower();
        System.out.println("Właściciel: " + this.id);
        System.out.println("Imię:   " + this.name);
        System.out.println("Nazwisko:   " + this.surname);
        System.out.println("Wiek: " + this.age);
        System.out.println("Płeć: " + this.gender);
        System.out.println("--Zwierzeta-- ");
        if (Animal.getAnimals().isEmpty()) {
            System.out.println("brak");
        } else {
            System.out.println("Ma zwierzęta");
            infoShower.showInfo(new ArrayList<>(Animal.getAnimals()));
        }
    }

    @Override
    public void idInfo() {
        System.out.println("Właściciel: " + this.id);
        System.out.println(this.name + " " + this.surname);
    }

    @Override
    public void infoAfterAYear() {
        System.out.println("Właściciel: " + this.id);
        System.out.println("Imię:   " + this.name);
        System.out.println("Nazwisko:   " + this.surname);
        System.out.println("Wiek: " + (this.age + 1));
        System.out.println("Płeć: " + this.gender);
        System.out.println("--Zwierzeta-- ");
        if (Animal.getAnimals().isEmpty()) {
            System.out.println("brak");
        } else {
            System.out.println("Ma zwierzęta");
            InfoShower infoShower = new InfoShower();
            infoShower.showInfoAYearLater(new ArrayList<>(Animal.getAnimals()));
        }
    }

    @Override
    public String getFileNameToSave() {
        return "Owners.txt";
    }

    @Override
    public String getDataToSave() {
        return this.id + "\n"
                + this.name + "\n"
                + this.surname + "\n"
                + this.age + "\n";
    }

    ///////////////////////// gettery i settery ///////////////////////////

    public static List<Owner> getOwners() {
        return owners;
    }

    public static List<Animal> getOwnerAnimals() {
        return ownerAnimals;
    }

}

