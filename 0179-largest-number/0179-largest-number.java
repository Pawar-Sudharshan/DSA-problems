class Solution {
    public String largestNumber(int[] nums) {
        String[] num = new String[nums.length];

        int i = 0;

        for (int x : nums) {
            num[i++] = String.valueOf(x);
        }

        Arrays.sort(num, (a, b) -> {
            return (b + a).compareTo(a + b);
        });

        // If the largest value is "0", all values are zero.
        if (num[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        for (String value : num) {
            result.append(value);
        }

        return result.toString();
    }
}