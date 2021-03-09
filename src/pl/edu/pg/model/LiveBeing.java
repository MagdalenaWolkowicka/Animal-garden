package pl.edu.pg.model;

public abstract class LiveBeing {

    //------------------- pola ----------------------------------

    protected int id;
    protected String name;
    protected int age;
    protected String gender;

    //------------------- metody ---------------------------------

    public LiveBeing(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public LiveBeing(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //////////////////////// gettery i settery /////////////////////////////

    public int getId() {
        return id;
    }
}
