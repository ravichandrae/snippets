import java.util.Arrays;

public class MaxMinElement {
    public static void main(String []args) {
        int []arr = {9, 69, 42, 36, 60};
        System.out.println(maxInteger(arr));
        System.out.println(maxInteger(null)); //Throws Null pointer exception
        System.out.println(maxInteger(new int[]{})); //Throws NoSuchElement exception
    }

    private static int maxInteger(int []arr) {
        return Arrays.stream(arr).max().getAsInt();
    }
}
