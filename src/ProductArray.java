import java.util.Arrays;

public class ProductArray {
    public static void main(String []args) {
        testProductArray();
        //testProductArrayBruteForce();
        //testProductArrayWithDivision();
    }

    private static void testProductArray() {
        Arrays.stream(productArray(new int[]{9})).forEach(System.out::println); //O/P: {1} Special case
        Arrays.stream(productArray(new int[]{4, 3, 1, 2})).forEach(System.out::println); // O/P: {6, 8, 24, 12}
        Arrays.stream(productArray(new int[]{5, 0, 3, 6, 2})).forEach(System.out::println); // O/P: {0, 180, 0, 0, 0}
    }

    private static void testProductArrayBruteForce() {
        Arrays.stream(productArrayBruteForce(new int[]{9})).forEach(System.out::println); //O/P: {1} Special case
        Arrays.stream(productArrayBruteForce(new int[]{4, 3, 1, 2})).forEach(System.out::println); // O/P: {6, 8, 24, 12}
        Arrays.stream(productArrayBruteForce(new int[]{5, 0, 3, 6, 2})).forEach(System.out::println); // O/P: {0, 180, 0, 0, 0}
    }

    private static void testProductArrayWithDivision() {
        Arrays.stream(productArrayWithDivision(new int[]{9})).forEach(System.out::println); //O/P: {1} Special case
        Arrays.stream(productArrayWithDivision(new int[]{4, 3, 1, 2})).forEach(System.out::println); // O/P: {6, 8, 24, 12}
        Arrays.stream(productArrayWithDivision(new int[]{5, 0, 3, 6, 2})).forEach(System.out::println); // O/P: {0, 180, 0, 0, 0}
    }

    /**
     * Calculate the product array in O(n) time and O(1) space using division operator.
     * @param arr int array
     * @return int array of products
     */
    private static int[] productArrayWithDivision(int []arr) {
        int []prodArray = new int[arr.length];
        long zeroCount = Arrays.stream(arr).filter(v -> v == 0).count();
        if(zeroCount > 1) {
            Arrays.fill(prodArray, 0);
        } else if(zeroCount == 1) {
            int product = Arrays.stream(arr).filter(v -> v != 0).reduce((a, b)->a * b).getAsInt();
            for(int i = 0; i < arr.length; ++i) {
                if(arr[i] == 0) {
                    prodArray[i] = product;
                } else {
                    prodArray[i] = 0;
                }
            }

        } else {
            int product = Arrays.stream(arr).reduce((a, b)->a * b).getAsInt();
            for(int i = 0; i < arr.length; ++i) {
                prodArray[i] = product/arr[i];
            }
        }
        return prodArray;
    }

    /**
     * Brute force approach to calculate product array; time complexity O(n^2), Space complexity O(1)
     * @param arr: integer array
     * @return int array
     */
    private static int[] productArrayBruteForce(int []arr) {
        int []prodArray = new int[arr.length];
        int i, j;
        for(i = 0; i < arr.length; i++) {
            prodArray[i] = 1;
            for(j = 0; j < arr.length; j++) {
                if(i != j) {
                    prodArray[i] *= arr[j];
                }
            }
        }
        return prodArray;
    }

    /**
     * Given an non-empty array of numbers, return an array of same length
     * where each element is the product of all elements except itself
     * Time complexity: O(n), space complexity O(1)
     * @param arr non empty array of numbers
     * @return int array
     */
    private static int [] productArray(int []arr) {
        int []productArray = new int[arr.length];
        Arrays.fill(productArray, 1);
        int i, p = 1;
        for(i = 0; i < arr.length; i++) {
            productArray[i] = p;
            p *= arr[i];
        }

        p = 1;
        for(i = arr.length-1; i >= 0; --i) {
            productArray[i] *= p;
            p *= arr[i];
        }
        return productArray;
    }
}
