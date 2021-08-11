import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveNumberSequence {
    public static void main(String []args) {
        System.out.println(longestConsecutiveSequence(new int[] {6, 2, 1, 4, 0})); //Expected 3 {0, 1, 2}
        System.out.println(longestConsecutiveSequence(new int[] {5, 3, 1, 7, 9})); //Expected 1 {Any element}
        System.out.println(longestConsecutiveSequence(new int[] {-2, 0, 3, 1, -1})); //Expected 4 {-2, -1, 0, 1}
        System.out.println(longestConsecutiveSequence(new int[] {1899, 1897, 1900, 1898, 1896})); //Expected 5 {all}
        System.out.println(longestConsecutiveSequence(new int[] {2020, 2020, 2020})); //Expected 1 {any}
    }

    /**
     * Given an array of numbers in random order, find the length of the longest sequence of numbers in it.
     * The numbers may not be placed together in the array.
     * Time complexity O(n log n)
     * Space complexity O(1)
     * This method also changes(mutate) the order of numbers (sort them)
     * @param nums: Array of numbers
     * @return integer: length of the longest sequence of consecutive numbers
     */
    private static int longestConsecutiveSequence1(int []nums) {
        if(null == nums || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int maxLength = 1, currentLength = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]+1) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }
        return maxLength;
    }

    /**
     * Given an array of numbers in random order, find the length of the longest sequence of numbers in it.
     * The numbers may not be placed together in the array.
     * Time complexity O(n)
     * Space complexity O(n) - Map
     * This method does not change the order of given numbers
     * @param nums: Array of numbers
     * @return integer: length of the longest sequence of consecutive numbers
     */
    private static int longestConsecutiveSequence(int []nums) {
        if(null == nums || nums.length == 0)
            return 0;
        Map<Integer, Boolean> numberMap = new HashMap<>();
        for(int v: nums) {
            numberMap.put(v, false);
        }
        int maxLength = 0, currentLength = 0;
        for(int v: nums) {
            if(!numberMap.getOrDefault(v, false)) {
                currentLength = 1;
                //Check if the sequence can be extended backward and forward until the sequence breaks
                for(int prev = v-1; numberMap.containsKey(prev); prev--) {
                    currentLength++;
                    numberMap.put(prev, true);
                }
                
                for(int next = v+1; numberMap.containsKey(next); next++) {
                    currentLength++;
                    numberMap.put(next, true);
                }
                maxLength = Math.max(currentLength, maxLength);
            }
        }
        return maxLength;
    }
}
