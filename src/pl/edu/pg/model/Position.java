package pl.edu.pg.model;

public class Position {

    private int row;
    private int column;

    public Position() {
        this.row = 0;
        this.column = 0;
    }

    ////////////////////////// gettery i settery //////////////////////////


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
