package pl.edu.pg.model;

import pl.edu.pg.interfaces.Visible;

public class Cat extends Animal implements Visible {

    //------------------- pola ----------------------------------

    private String breed;

    //------------------- metody ---------------------------------

    public Cat(String name, int age, String breed, String gender, int ownerId) {
        super(name, age, gender, ownerId);
        this.breed = breed;
        this.type = Type.CAT;
    }

    @Override
    public void info() {
        printBasicInfo("Kot");
        System.out.println("Rasa: " + this.breed);
    }

    @Override
    public void idInfo() {
    }

    @Override
    public void infoAfterAYear() {
        if (this.age + 1 > 20) {
            Animal.getAnimals().remove(this);
            System.out.println("Kot zdechł");
        } else {
            System.out.println("Kot" + " " + this.id);
            System.out.println("Imię: " + this.name);
            System.out.println("Wiek:   " + (this.age + 1));
            System.out.println("Właściciel: " + ownerId);
            System.out.println("Płeć: " + this.gender);
            System.out.println("Rasa: " + this.breed);
        }
    }

    @Override
    public String getFileNameToSave() {
        return "Animals.txt";
    }

    @Override
    public String getDataToSave() {
        return "Kot " + this.id + "\n"
                + "Imię: " + this.name + "\n"
                + "Wiek: " + this.age + "\n"
                + "Numer właściciela: " + this.ownerId + "\n"
                + "Rasa: " + this.breed + "\n";
    }
}
