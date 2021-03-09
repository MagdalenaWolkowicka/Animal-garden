package pl.edu.pg.model;

import pl.edu.pg.interfaces.Visible;

public class Turtle extends Animal implements Visible {

    //------------------- pola ---------------------------------

    private boolean active;

    //------------------- metody ---------------------------------

    public Turtle(String name, int age, boolean active, String gender, int ownerId) {
        super(name, age, gender, ownerId);
        this.active = active;
        this.type = Type.TURTLE;
        this.gender = gender;
    }

    @Override
    public void info() {
        printBasicInfo("Żółw");
        System.out.println("Stan: " + (active ? "Aktywny" : "Schowany w skorupie"));
    }

    @Override
    public void idInfo() {
    }

    @Override
    public void infoAfterAYear() {
        if (this.age + 1 > 100) {
            Animal.getAnimals().remove(this);
            System.out.println("Żółw zdechł");
        } else {
            System.out.println("Żółw " + this.id);
            System.out.println("Imię: " + this.name);
            System.out.println("Wiek:   " + (this.age + 1));
            System.out.println("Właściciel: " + ownerId);
            System.out.println("Płeć: " + this.gender);
        }
    }

    @Override
    public String getFileNameToSave() {
        return "Animals.txt";
    }

    @Override
    public String getDataToSave() {
        return "Żółw " + this.id + "\n"
                + "Imię: " + this.name + "\n"
                + "Wiek: " + this.age + "\n"
                + "Numer właściciela: " + this.ownerId + "\n"
                + "Aktywność: " + this.active + "\n";
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
