package battleships;

import java.util.List;
import java.util.Set;

public class GameDriver {
    public static void main(String[] args) {
        /*
        M i.e GridSize [Matrix of M*M]
        S i.e TotalShips
        P1 Ship Positions: 1:1,2:0,2:3,3:4,.. (x:y pairs separated by commas)
        P2 Ship Positions: 0:1,2:0,2:3,3:4,...
        T i.e TotalMissiles
        P1 moves: 1,1:2:0… (x,y pairs of length ’T’)
        P2 moves: 1,2:3:0… (x,y pairs of length ‘T’)

        5
        5
        1:1,2:0,2:3,3:4,4:3
        0:1,2:3,3:0,3:4,4:1
        5
        0,1:4,3:2,3:3,1:4,1
        0,1:0,0:1,1:2,3:4,3
        */
        int m = 5;
        int s = 5;
        Set<Cell> player1ShipPositions = Set.of(new Cell(1,1, ShipType.B),
            new Cell(2,0, ShipType.B),
            new Cell(2,3, ShipType.B),
            new Cell(3,4, ShipType.B),
            new Cell(4,3, ShipType.B));

        Set<Cell> player2ShipPositions = Set.of(new Cell(0,1, ShipType.B),
            new Cell(2,3, ShipType.B),
            new Cell(3,0, ShipType.B),
            new Cell(3,4, ShipType.B),
            new Cell(4,1, ShipType.B));

        int missiles = 5;

        Set<Cell> player1MissileMoves = Set.of(new Cell(0,1, null),
            new Cell(4,3, null),
            new Cell(2,3, null),
            new Cell(3,1, null),
            new Cell(4,1, null));

        Set<Cell> player2MissileMoves = Set.of(new Cell(0,1, null),
            new Cell(0,0, null),
            new Cell(1,1, null),
            new Cell(2,3, null),
            new Cell(4,3, null));

        BattleshipsGame game = new BattleshipsGame();
        game.process(player1ShipPositions, player2ShipPositions, player1MissileMoves, player2MissileMoves);
    }
}
