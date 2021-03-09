package pl.edu.pg.functions;

import pl.edu.pg.model.Animal;

import java.util.ArrayList;
import java.util.Scanner;

import static pl.edu.pg.Garden.SIZE;

public class AnimalMover {

    Animal animalMove;
    int animalId;

    public void moveAnimal() {
        if (Animal.getAnimals().isEmpty()) {
            System.out.println("Brak zwierząt");
        } else {
            InfoShower infoShower = new InfoShower();
            infoShower.showInfo(new ArrayList<>(Animal.getAnimals()));
            System.out.println("Wybierz zwierzę, które ma się poruszyć: ");
            Scanner scanner = new Scanner(System.in);
            animalId = scanner.nextInt();
            if (animalId >= Animal.getAnimals().size() + 1 || animalId < 0) {
                System.out.println("Nie ma zwierzecia o takim numerze.");
                return;
            } else {
                System.out.println("Ruszam zwierzęciem nr " + animalId);
                animalMove = Animal.getAnimals().get(animalId - 1);
                displayCurrentPosition();
            }
            System.out.println("Podaj kierunek ruchu");
            System.out.println("(1 - góra, 2 - dół, 3 - lewo, 4 - prawo):");
            int moveOption = scanner.nextInt();
            switch (moveOption) {
                case 1:
                    moveUp(animalMove);
                    break;
                case 2:
                    moveDown(animalMove);
                    break;
                case 3:
                    moveLeft(animalMove);
                    break;
                case 4:
                    moveRight(animalMove);
                    break;
                default:
                    System.out.println("Błędny wybór");
            }
        }
    }

    public void moveUp(Animal animalMove) {
        if (animalMove.getPosition().getRow() == 0) {
            System.out.println("Za blisko płotu, nie da się poruszyć w tą strone");
        } else {
            animalMove.getPosition().setRow(animalMove.getPosition().getRow() - 1);
            displayNewPosition();
        }
    }

    public void moveDown(Animal animalMove) {
        if (animalMove.getPosition().getRow() == SIZE) {
            System.out.println("Za blisko płotu, nie da się poruszyć w tą strone");
        } else {
            animalMove.getPosition().setRow(animalMove.getPosition().getRow() + 1);
            displayNewPosition();
        }
    }

    public void moveRight(Animal animalMove) {
        if (animalMove.getPosition().getColumn() == SIZE) {
            System.out.println("Za blisko płotu, nie da się poruszyć w tą strone");
        } else {
            animalMove.getPosition().setColumn(animalMove.getPosition().getColumn() + 1);
            displayNewPosition();
        }
    }

    public void moveLeft(Animal animalMove) {
        if (animalMove.getPosition().getColumn() == 0) {
            System.out.println("Za blisko płotu, nie da się poruszyć w tą strone");
        } else {
            animalMove.getPosition().setColumn(animalMove.getPosition().getColumn() - 1);
            displayNewPosition();
        }
    }

    public void displayNewPosition() {
        if (animalMove.getPosition().getRow() < 0 || animalMove.getPosition().getRow() > SIZE
                || animalMove.getPosition().getColumn() < 0 || animalMove.getPosition().getColumn() > SIZE) {
            System.out.println("Zwierzę weszło w płot. Pozostaje na poprzedniej pozycji");
            displayCurrentPosition();
        } else {
            System.out.println("Nowa pozycja zwierzęcia nr " + animalId);
            System.out.println("Rząd: " + animalMove.getPosition().getRow());
            System.out.println("Kolumna: " + animalMove.getPosition().getColumn());
        }
    }

    public void displayCurrentPosition() {
        System.out.println("Obecna pozycja zwierzęcia nr " + animalId);
        System.out.println("Rząd: " + animalMove.getPosition().getRow());
        System.out.println("Kolumna: " + animalMove.getPosition().getColumn());
    }
}