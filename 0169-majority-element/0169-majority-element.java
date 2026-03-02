class Solution {
   public int majorityElement(int[] nums) {
    int element = 0;
    int count = 0;
    for (int x : nums) {
        if (count == 0) {
            element = x;
            count = 1;
        } else if (x == element) {
            count++;
        } else {
            count--;
        }
    }
    return element;
}

}