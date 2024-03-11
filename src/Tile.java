public abstract class Tile {

    //Attributes
    private boolean revealed;
    private boolean clickable;
    private boolean flag;
    private GameBoard board;

    //Methods

    protected abstract boolean open();

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





}
