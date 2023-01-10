import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class RandomPasswordGenerator {
    /*
    1. 5 UC
    2. 4 SC
    3. 1 SP
    4. 4 D
    * */

    static final Integer CAPITAL_COUNT = 5;
    static final Integer LOWER_COUNT = 4;
    static final Integer SPECIAL_COUNT = 1;
    static final Integer NUMBER_COUNT = 4;

    public static void main(String[] args) {
        var response = generatePassword();
        System.out.println("Password: " + response);
    }

    private static String generatePassword() {
        PriorityQueue<Character> characters = new PriorityQueue<>((a,b) -> {
            return (int) (Math.random()*6832832)%73;
        });
        int capitalCount = 0;
        int lowerCount = 0;
        int specialCount = 0;
        int numberCount = 0;

        while(capitalCount < CAPITAL_COUNT) {
            int random = (int)(Math.random()*9912)%26;
            if(!characters.contains((char)(random+'A'))) {
                characters.add((char) (random + 'A'));
                capitalCount++;
            }
        }


        while(lowerCount < LOWER_COUNT) {
            int random = (int)(Math.random()*9912)%26;
            if(!characters.contains((char)(random+'a'))) {
                characters.add((char) (random + 'a'));
                lowerCount++;
            }
        }

        while(specialCount < SPECIAL_COUNT) {
            int random = (int)(Math.random()*1000)%65;

            if(!characters.contains((char)(random))) {
                characters.add((char) (random));
                specialCount++;
            }
        }

        while(numberCount < NUMBER_COUNT) {
            int random =(int)(Math.random()*1000)%9;
            if(!characters.contains((char)(random+'0'))) {
                characters.add((char) (random + '0'));
                numberCount++;
            }
        }

        StringBuilder password = new StringBuilder();
        while(!characters.isEmpty()) {
            Character removedCharacter = characters.remove();
            password.append(removedCharacter);
        }

        System.out.println(characters);
        return password.toString();
    }

}

//class PasswordCharacter implements Runnable {
//    String character;
//
//    private PasswordCharacter() {
//        this.character = character;
//    }
//
//    public static PasswordCharacter getInstance() {
//        if(this == null) {
//            return new PasswordCharacter();
//        }
//        return this;
//    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        PasswordCharacter that = (PasswordCharacter) o;
//        return character.equals(that.character);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(character);
//    }
//}