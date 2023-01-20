package battleships;

public class Cell {
    int x;
    int y;
    ShipType shipType;

    public Cell(int x, int y, ShipType shipType) {
        this.x = x;
        this.y = y;
        this.shipType = shipType;
    }

    public Cell setShipType(ShipType shipType) {
        this.shipType = shipType;
        return this;
    }
}
