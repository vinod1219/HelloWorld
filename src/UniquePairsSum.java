import java.util.HashSet;

public class UniquePairsSum {
    public static void findPairs(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> uniquePairs = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                String pair = Math.min(num, complement) + "," + Math.max(num, complement);
                if (!uniquePairs.contains(pair)) {
                    uniquePairs.add(pair);
                    System.out.println("(" + num + ", " + complement + ")");
                }
            }
            seen.add(num);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 5, 9, 3, 6, 5, 7};
        int target = 10;
        System.out.println("Unique pairs that sum to " + target + ":");
        findPairs(arr, target);
    }
}

