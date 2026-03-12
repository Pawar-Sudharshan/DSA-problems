class Solution {

     static class Node{
        Node child[] = new Node[2];
        Node(){
            for(int i = 0 ; i < 2 ;i++) this.child[i] =null;
        }
    }
    public static void insert(Node root , int x){
        Node temp = root;
        for(int i =31; i >= 0 ;i--){
            int bit  = ( x >> i) &1;
            if(temp.child[bit] == null) {
                temp.child[bit] = new Node();
            }
            temp = temp.child[bit];          
        }
    }

    public static int getValue(Node root , int q){
        int ans = 0;
        Node temp = root;
        for(int i=31;i>=0;i--)
        {
            int bit = (q>>i)&1;
            if(temp.child[bit^1] != null){
                ans += (1<<i);
                temp = temp.child[bit^1];
            }
            else temp = temp.child[bit];
        }
        return ans;
    }

    public int findMaximumXOR(int[] A) {
         int n =A.length;
            Node root = new Node();
            for(int i = 0 ; i < n ;i++) { 
                insert(root , A[i]);
            }
            int max = 0;
            for(int i=0;i<n;i++)
            {
                max = Math.max(max,getValue(root,A[i]));
            }
            return max;
    }
}