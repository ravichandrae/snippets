public class RotatedBinarySearch {
    public static void main(String[] args) {
        //Boundary conditions
        System.out.println(rotatedBinarySearch(null, 123)); //Expected -1
        System.out.println(rotatedBinarySearch(new int[]{}, 123)); //Expected -1
        //Zero rotations
        System.out.println(rotatedBinarySearch(new int[]{10, 20, 30, 40, 50}, 40)); //Expected 3
        //One rotation
        System.out.println(rotatedBinarySearch(new int[]{67, 77, 89, 99, 56}, 77)); //Expected 1
        //No element found
        System.out.println(rotatedBinarySearch(new int[]{45, 90, 120, 34, 40}, 123)); //Expected -1
        //Negative elements
        System.out.println(rotatedBinarySearch(new int[]{567, -345, -298, 0, 100}, 567)); //Expected 0
    }

    public static int rotatedBinarySearch(int[] arr, int val) {
        if (arr == null || arr.length == 0)
            return -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; //To avoid overflow while calculating the mid; it is same as (low+high)/2
            if (arr[mid] == val)
                return mid;
            if (arr[low] <= arr[mid]) { //Left half of the array is sorted
                if (val >= arr[low] && val < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { //Right half of the array is sorted
                if (val > arr[mid] && val <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
