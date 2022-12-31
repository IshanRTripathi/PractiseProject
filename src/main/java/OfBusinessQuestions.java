public class OfBusinessQuestions {
    /*

    We'll say that a value is "everywhere" in an array if for every pair of adjacent elements
    in the array, at least one of the pair is that value.
    Return true if the given value is everywhere in the array.


        isEverywhere([1, 2, 1, 3], 1) → true
        isEverywhere([1, 2, 1, 3], 2) → false
        isEverywhere([1, 2, 1, 3, 4], 1) → false
*/
    int balance = 300;
    public static void main(String[] args) {
        int[] tc1 = {1, 2, 1, 3};
        int[] tc2 = {1, 2, 1, 3};
        int[] tc3 = {1, 2, 1, 3, 4, 6, 1};
        System.out.println(isEverywhere(tc1, 1));
        System.out.println(isEverywhere(tc2, 2));
        System.out.println(isEverywhere(tc3, 1));
    }

    private static boolean isEverywhere(int[] input, int target) {
        if(input == null || input.length < 2) {
            return false;
        }

        for(int i=0; i<input.length-1; i++) {
            if(input[i] != target && input[i+1] != target){
                return false;
            }
        }

        return true;
    }

//    @Transactional()
//    public void methodA(){
//        methodB();
//        // saving another data2
//    }
//
//    @Transactional()
//    private void methodB(){
//        // saving data;
//    }


    public synchronized boolean deductAmount(int amount) {
        if(balance - amount >=0) {
            balance-= amount;
            System.out.println("Amount deducted");
        } else {
            System.out.println("Cannot deduct amount");
            return false;
        }
        return true;
    }
}
