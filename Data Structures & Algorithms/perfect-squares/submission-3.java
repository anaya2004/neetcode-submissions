class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i =2;i<=n;i++){
            //now calculating for i
            int count = Integer.MAX_VALUE;
            for(int j = 1;j*j<=i;j++){
                count = Math.min(count,dp[i-(j*j)]);
            }
            dp[i] = count+1;
        }
        return dp[n];
    }
}