package pl.edu.pg.model;

import pl.edu.pg.interfaces.Saveable;
import pl.edu.pg.interfaces.Visible;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal extends LiveBeing implements Visible, Saveable {

    //-------------------- enumy -------------------------------

    public enum Type {
        CAT("Kot"), DOG("Pies"), TURTLE("Żółw");

        private String valuePl;

        Type(String valuePl) {
            this.valuePl = valuePl;
        }
    }

    //------------------- pola ----------------------------------

    private static int animalCount = 0;
    protected Owner owner;
    public int ownerId;
    private static List<Animal> animals = new ArrayList<>();
    protected Type type;
    protected Position position;

    //------------------- metody ---------------------------------

    public Animal(String name, int age, String gender, int ownerId) {
        super(name, age, gender);
        this.id = ++animalCount;
        this.ownerId = ownerId;
        animals.add(this);
        this.position = new Position();

    }

    protected void printBasicInfo(String animalType) {
        System.out.println(animalType + " " + this.id);
        System.out.println("Imię: " + this.name);
        System.out.println("Wiek:   " + this.age);
        System.out.println("Właściciel: " + ownerId);
        System.out.println("Płeć: " + this.gender);
        System.out.println("Pozycja: rząd --> " + this.position.getRow() + " kolumna --> " + this.position.getColumn());
    }

    @Override
     public void infoAfterAYear() {
    }

    public String getFileNameToSave() {
        return "Animals.txt";
    }

    //////////////////////// gettery ////////////////////////////////////

    public static List<Animal> getAnimals() {
        return animals;
    }

    public Type getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }
}
