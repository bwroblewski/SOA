public class Seat {

    private int row, col, price;

    private boolean taken;

    public Seat(int row, int col, int price, boolean taken) {
        this.row = row;
        this.col = col;
        this.price = price;
        this.taken = taken;
    }

    public int getPrice() {
        return price;
    }


    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }


    public boolean isTaken() {
        return taken;
    }

    public void reserve() {
        this.taken = true;
    }
}
