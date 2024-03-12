public abstract class Tile {

    //Attributes
    protected boolean revealed;
    protected boolean clickable;
    protected boolean flag;
    protected Tile[][] tiles;

    protected int row;
    protected int column;

    //Methods

    protected Tile(int row, int column) {
        this.row = row;
        this.column = column;
        clickable = true;
    }

    protected abstract boolean open();

    protected void flag() {
        setClickable(false);
        flag = true;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
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
