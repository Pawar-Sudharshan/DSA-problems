class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] n1 = num1.split("\\+|i");
        String[] n2 = num2.split("\\+|i");
        int real1=Integer.parseInt(n1[0]);
        int img1=Integer.parseInt(n1[1]);
        int real2 =Integer.parseInt(n2[0]);
        int img2 = Integer.parseInt(n2[1]);
        int real = real1*real2 - img1*img2;
        int img = img1*real2 + img2*real1;
        return real+"+"+img+"i";
    }
}