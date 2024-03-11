public class Tile {

    //Attributes
    protected boolean revealed;
    protected boolean clickable;
    protected boolean flag;
    protected GameBoard board;

    protected int row;
    protected int column;

    //Methods

    protected Tile(int row, int column) {
        this.row = row;
        this.column = column;
    }

    protected boolean open() {
        return false;
    }

    protected void flag() {
        setClickable(false);
        flag = true;
    }

    protected void setReveal(boolean reveal) {
        revealed = reveal;
    }

    protected boolean getReveal() {
        return revealed;
    }

    protected void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    protected boolean getClickable() {
        return clickable;
    }

    protected int getRow() {
        return row;
    }

    protected int getColumn() {
        return column;
    }







}
