public class IntegerValueOf {
    public static void main(String[] args) {
        //System.out.println((int) Double.parseDouble("70"));
//        System.out.println(isPositiveInteger("0.0"));
//        System.out.println((int) Double.parseDouble("0.0"));
//        System.out.println(Long.parseLong(String.valueOf(
//            Math.floor(Double.parseDouble("0.0")
//            ))));
//        System.out.println(Long.parseLong("0"));
        System.out.println((int) Double.parseDouble("0.000"));
        Double dd = 10.0;
//                   Long.parseLong(String.valueOf((int) Double.parseDouble(item.getQuantity().getQuantityNumber().toString())))
//        Long res = Long.parseLong(Integer.paString.valueOf(Math.abs(dd)));
//        System.out.println(res);
    }
    private static boolean isPositiveInteger(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c: str.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
