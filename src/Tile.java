public abstract class Tile {

    //Attributes
    protected boolean revealed;
    protected boolean clickable;
    protected boolean flag;
    protected Tile[][] tiles;

    protected int row;
    protected int column;
    protected boolean opened;

    //Methods

    protected Tile(int row, int column) {
        this.row = row;
        this.column = column;
        clickable = true;
    }

    protected abstract boolean open();

    protected void flag() {
        if(opened) return;
        if (flag)
        {
            setClickable(true);
            flag = false;
        }
        else
        {
            setClickable(false);
            flag = true;
        }

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

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
}
