import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        BigInteger n = new BigInteger(s, 2);
        BigInteger one = BigInteger.ONE;
        int ans = 0;

        while (!n.equals(one)) {
            if (n.testBit(0) == false) {       
                n = n.shiftRight(1);
            } else {                          
                n = n.add(one);
            }
            ans++;
        }
        return ans;
    }
}
