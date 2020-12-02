import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class CountSmallerElementsRight {
    public static void main(String []args) {
        int []nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        countSmaller(nums);
    }
    public static List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> result= new LinkedList<>();
        if(null == nums || nums.length < 1)
            return result;
        SortedSet<Integer> set = new TreeSet<>();
        set.add(nums[nums.length-1]);
        result.addFirst(0);
        int i;
        for(i = nums.length-2; i >= 0; i--) {
            SortedSet<Integer> hs = set.headSet(nums[i]);
            for(int v: hs) {
                System.out.print(v + " ");
            }
            System.out.println();
            result.addFirst(hs.size());
            set.add(nums[i]);
        }
        return result;
    }
}
