package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessTournament {
    public static void main(String[] args) {
        System.out.println(getMaxPotential(new ArrayList<>(List.of(3,1,2,4)), 2));
    }

    private static int getMaxPotential(List<Integer> potential, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x: potential){
            map.put(x, 0);
        }
        k= k%potential.size();
        while(true){
            int removed;
            int winner;
            if(potential.get(0) > potential.get(1)) {
                removed = potential.remove(1);
                winner = potential.get(0);
            } else {
                removed = potential.remove(0);
                winner = potential.get(1);
            }
            potential.add(removed);
            map.put(winner, map.get(winner)+1);
            if(map.get(winner)==k){
                return winner;
            }
        }
    }
}
