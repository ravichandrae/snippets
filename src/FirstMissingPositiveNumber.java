public class FirstMissingPositiveNumber {
    public static void main(String []args) {
        testFirstMissingPositiveNumber();
    }

    /**
     * Given an array of positive and negative numbers, return first missing positive number.
     * @param arr Unordered array of positive and negative numbers
     * @return first missing positive number.
     */
    private static int firstMissingPositiveNumber(int []arr) {
        int positiveIndex = groupPositiveNegative(arr);
        if(positiveIndex < 0) { //null or empty array
            return -1;
        }
        if(positiveIndex == arr.length) // arr contains all negatives
            return 1;
        int positiveCount = arr.length - positiveIndex; //count of positive numbers
        //Make use of the positive element group of the array for keeping track of the positive numbers.
        //So we are going to modify the array
        //mark arr[positiveIndex] as negative if 1 is present
        //mark arr[positiveIndex + 1] as negative if 2 is present and so on...
        //mark arr[positiveIndex+ v - 1] as negative v is present in the array
        int i;
        for(i = positiveIndex; i < arr.length; i++) {
            int val = Math.abs(arr[i]);
            if(val <= positiveCount) {
                if(arr[val + positiveIndex - 1] > 0) {
                    arr[val + positiveIndex - 1] = -arr[val + positiveIndex - 1];
                }
            }
        }
        //Finally check for the elements which are not marked negative;
        //At the end of the loop, i+1 would be missing positive number,
        //since the array boundary started at positiveIndex, we need to add it.
        for(i = positiveIndex; i < arr.length; i++) {
            if(arr[i] > 0) {
                break;
            }
        }
        return i - positiveIndex + 1;
    }

    private static void testFirstMissingPositiveNumber() {
        System.out.println(firstMissingPositiveNumber(new int[]{3})); //Expected output: 1
        System.out.println(firstMissingPositiveNumber(new int[]{})); //Expected output: 1
        System.out.println(firstMissingPositiveNumber(new int[]{8, 0, -3, 6, -1, 9})); //Expected output: 1
        System.out.println(firstMissingPositiveNumber(new int[]{5, 1, 4, 6, 7, 2})); //Expected output: 3
        System.out.println(firstMissingPositiveNumber(new int[]{-9, -3, -5, -4, -2})); //Expected output: 1
        System.out.println(firstMissingPositiveNumber(new int[]{-6, -8, 0, -5, -9, 1})); //Expected output: 2
        System.out.println(firstMissingPositiveNumber(new int[]{-6, -8, 2, -5, 3, 1})); //Expected output: 4
    }

    /**
     * Given an array of numbers, group negative and positive numbers together by re-arranging the array
     * All non positive numbers should appear before the positive numbers, order does not matter
     * @param arr: array of positive and negative numbers
     * @return An index which represent the starting point of the positive numbers
     */
    private static int groupPositiveNegative(int []arr) {
        if(null == arr) {
            return -1;
        }
        if(arr.length == 0) {
            return 0;
        }
        int i, j;
        for(i = 0, j = arr.length; i < j; ) {
            while( i < arr.length && arr[i] <= 0) {
                i++;
            }

            while(j > 0 && arr[j-1] > 0) {
                j--;
            }
            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j-1];
                arr[j-1] = temp;
            }
        }
        return j;
    }

    private static void testGroupPositiveNegative() {
        System.out.println(groupPositiveNegative(null)); //Expected output: -1
        System.out.println(groupPositiveNegative(new int[]{})); //Expected output: 0
        System.out.println(groupPositiveNegative(new int[]{8, 0, -3, 6, -1, 9})); //Expected output: 3
        System.out.println(groupPositiveNegative(new int[]{5, 1, 4, 6, 7, 2})); //Expected output: 0
        System.out.println(groupPositiveNegative(new int[]{7, 3, 8, 7, 5, 0})); //Expected output: 1
        System.out.println(groupPositiveNegative(new int[]{-9, -3, -5, -4, -2})); //Expected output: 5
        System.out.println(groupPositiveNegative(new int[]{-6, -8, 0, -5, -9, -6})); //Expected output: 6
    }

    /**
     * Given an array of non-negative numbers, return the first missing positive number
     * @param arr: array of non-negative numbers
     * @return First positive missing number
     */
    private static int firstMissingPositiveNum(int []arr) {
        //Assuming that we need to return -1 if array is null;
        //We can also chose to ignore this return and let it throw NullPointerException
        if(null == arr) {
            return -1;
        }
        if(arr.length == 0) {
            return 1;
        }

        int i;
        for(i = 0; i < arr.length; i++) {
            int val = Math.abs(arr[i]);
            //Check if we can represent this value in the array within the index range
            //negate the array element at index (val-1)
            if(val != 0 && val <= arr.length) {
               if(arr[val-1] > 0) {
                   arr[val-1] = -arr[val-1];
               }
            }
        }

        for(i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                break;
            }
        }
        return i+1;
    }
    private static void testFirstMissingPositiveNum() {
        System.out.println(firstMissingPositiveNumber(new int[]{3})); //Expected output: 1
        System.out.println(firstMissingPositiveNumber(new int[]{})); //Expected output: 1
        System.out.println(firstMissingPositiveNumber(new int[]{4, 1, 2, 6, 5})); //Expected output: 3
        System.out.println(firstMissingPositiveNumber(new int[]{1, 2, 3, 4, 5, 7})); //Expected output: 6
        System.out.println(firstMissingPositiveNumber(new int[]{7, 5, 4, 3, 2, 1})); //Expected output: 6
        System.out.println(firstMissingPositiveNumber(new int[]{9, 2, 8, 1, 3, 6, 5, 7, 4})); //Expected output: 10
    }
}
