package pl.edu.pg;

public class Garden {

    public static final int SIZE = 15;

    public void strat() {

        System.out.println("Witamy w ogrodzie :)");
        System.out.println("------------------------------");
        Menu menu = new Menu();
        while (true) {
            menu.showMenu();
            menu.actionMenu();
        }
    }
}
