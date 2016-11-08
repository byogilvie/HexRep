
/**
 * The HexRep class converts a set of numbers given in the command line to
 * hexadecimal form and puts them in a table. The numbers must be positive
 * integers.
 *
 * @author Bradley Ogilvie
 *
 */
public class HexRep {

    /**
     * This array is used to help the convert method convert numbers to letters.
     */
    private static String[] list = {"A", "B", "C", "D", "E", "F"};

    public static void main(String[] args) {
        /**
         * These lines of code get the integers from the command line. It also
         * checks to make sure they are integers. If they are, the code
         * continues to make a table of the values.
         */
        int start = 0, stop = 0;
        try {
            start = Integer.parseInt(args[0]);
            stop = Integer.parseInt(args[1]);
        } catch (java.lang.NumberFormatException e) {
            StdOut.println("NumberFormatException: " + e.getMessage());
        }
        StdOut.println("Decimal\tHex");
        for (int i = start; i <= stop; i++) {
            StdOut.println(i + "\t" + toHexadecimal(i));
        }
    }

    private static String toHexadecimal(int n) {//This method converts the number given to hexadecimal
        if (n < 0) {//This error is thrown when the given value is negative.
            throw new RuntimeException("cannot be negative");
        }
        if (n < 16) {//base case for the method.  Works when n is less than 16.
            return convert(n);
        }
        return toHexadecimal(n / 16) + convert(n % 16);
    }

    private static String convert(int n) {//This method helps with the conversion
        if (n < 10) {//returns a string of the number if it is between 0 - 9
            return Integer.toString(n);
        }
        return list[n - 10];//else it uses the array above to return the appropiete letter.
    }
}
