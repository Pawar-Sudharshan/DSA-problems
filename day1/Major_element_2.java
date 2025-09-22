public class Major_element_2 {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
    
    public static void main(String[] args) {
        Major_element_2 solution = new Major_element_2();
        
        // Test case 1
        int[] nums1 = {3, 2, 3};
        System.out.println("Input: [3,2,3]");
        System.out.println("Output: " + solution.majorityElement(nums1));
        
        // Test case 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Input: [2,2,1,1,1,2,2]");
        System.out.println("Output: " + solution.majorityElement(nums2));
    }
}