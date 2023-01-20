package battleships;

import java.util.Set;

public class BattleshipsGame {

    public void process(Set<Cell> player1ShipPositions, Set<Cell> player2ShipPositions, Set<Cell> player1MissileMoves, Set<Cell> player2MissileMoves) {
        for(Cell cell: player1MissileMoves) {
            Cell currentMissileShipPosition = new Cell(cell.x, cell.y, ShipType.B);
            if(player2ShipPositions.contains(currentMissileShipPosition)) {
                player2ShipPositions.remove(currentMissileShipPosition);
                currentMissileShipPosition.setShipType(ShipType.X);
            } else {
                currentMissileShipPosition.setShipType(ShipType.O);
            }
            player2ShipPositions.add(currentMissileShipPosition);
        }

        for(Cell cell: player2MissileMoves) {
            Cell currentMissileShipPosition = new Cell(cell.x, cell.y, ShipType.B);
            if(player1ShipPositions.contains(currentMissileShipPosition)) {
                player1ShipPositions.remove(currentMissileShipPosition);
                currentMissileShipPosition.setShipType(ShipType.X);
            } else {
                currentMissileShipPosition.setShipType(ShipType.O);
            }
            player1ShipPositions.add(currentMissileShipPosition);
        }

        System.out.println("Player 1 ship positions: " + player1ShipPositions);
        System.out.println("Player 2 ship positions: " + player2ShipPositions);
    }
}
