public class PalindromeChecker {
    public static void main(String[] args) {
        var response1 = checkPalindrome("abccba");
        var response2 = checkPalindrome("");
        var response3 = checkPalindrome("a");
        var response4 = checkPalindrome("aba");
        var response5 = checkPalindrome("asjfdlsjdavba");

        System.out.println(response1 + "\n" + response2 + "\n" + response3 + "\n" + response4 + "\n" + response5 + "\n" );
    }
    private static boolean checkPalindrome(String input) {
        if(input.isBlank()) {
            return true;
        }
        int leftPointer = 0, rightPointer = input.length()-1;

        while(leftPointer < rightPointer) {
            if(input.charAt(leftPointer) != input.charAt(rightPointer)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}
