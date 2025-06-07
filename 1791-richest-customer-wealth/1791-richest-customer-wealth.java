class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum=0;int maxSum=Integer.MIN_VALUE;
        int n=accounts.length;
        int m=accounts[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum=sum+accounts[i][j];
            }
            if(maxSum<sum){
                maxSum=sum;
            }
            sum=0;
        }
        return maxSum;
    }
}